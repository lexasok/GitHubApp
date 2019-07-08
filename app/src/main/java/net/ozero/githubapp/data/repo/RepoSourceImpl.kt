package net.ozero.githubapp.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import net.ozero.githubapp.data.repo.local.RepoDao
import net.ozero.githubapp.data.repo.local.toLocalModel
import net.ozero.githubapp.data.repo.remote.ApiClient
import net.ozero.githubapp.entity.InternetError
import net.ozero.githubapp.entity.Repo
import net.ozero.githubapp.entity.Result
import net.ozero.githubapp.usecase.repos.RepoSource

class RepoSourceImpl(private val apiClient: ApiClient, private val repoDao: RepoDao) : RepoSource {

    override suspend fun save(repo: Repo) = CoroutineScope(IO).launch {
        repoDao.insert(repo.toLocalModel())
    }

    override suspend fun saveAll(repos: List<Repo>) = CoroutineScope(IO).launch {
        repoDao.insertAll(*repos.map { it.toLocalModel() }.toTypedArray())
    }

    override fun observeAll(): LiveData<List<Repo>> = Transformations
        .map(repoDao.observeAll()) { list ->
            list.map { it.mapToDomain() }
        }

    override suspend fun loadMoreAsync(): Deferred<Result<List<Repo>>> = CoroutineScope(IO).async {
        val response = apiClient.reposAsync().await()
        val body = response.body()

        // TODO try to bring to Consumer
        if (response.isSuccessful && body != null) {
            val result = body.map { it.mapToDomain() }
            Result(result)
        } else {
            Result(error = InternetError(response.message()))
        }
    }
}