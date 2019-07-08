package net.ozero.githubapp.usecase.repos

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import net.ozero.githubapp.entity.Repo
import net.ozero.githubapp.usecase.ObservableUseCase

interface ObserveReposUseCase : ObservableUseCase<List<Repo>> {

    class Impl(private val repoSource: RepoSource) : ObserveReposUseCase {

        override suspend fun executeAsync(): Deferred<LiveData<List<Repo>>> =
            CoroutineScope(Dispatchers.IO).async {
                repoSource.observeAll()
            }
    }
}