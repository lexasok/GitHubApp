package net.ozero.githubapp.usecase.repos

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import net.ozero.githubapp.entity.Repo
import net.ozero.githubapp.usecase.ObservableParamsUseCase
import net.ozero.githubapp.usecase.ObservableUseCase

interface ObserveRepoByIdUseCase : ObservableParamsUseCase<Repo, Long> {

    class Impl(private val repoSource: RepoSource) : ObserveRepoByIdUseCase {

        override suspend fun executeAsync(params: Long): Deferred<LiveData<Repo>> =
            CoroutineScope(Dispatchers.IO).async {
                repoSource.observeById(params)
            }
    }
}