package net.ozero.githubapp.usecase.repos

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import net.ozero.githubapp.entity.Repo
import net.ozero.githubapp.entity.Result

interface RepoSource {

    suspend fun save(repo: Repo): Job

    suspend fun saveAll(repos: List<Repo>): Job

    fun observeAll(): LiveData<List<Repo>>

    fun observeById(id: Int): LiveData<Repo>

    suspend fun loadMoreAsync() : Deferred<Result<List<Repo>>>
}