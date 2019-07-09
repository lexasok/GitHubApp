package net.ozero.githubapp.usecase.repos

import kotlinx.coroutines.*
import net.ozero.githubapp.usecase.UseCase

interface LoadMoreReposUseCase : UseCase<Unit> {

    class ImplDraft(private val repoSource: RepoSource): LoadMoreReposUseCase {

        override suspend fun executeAsync(): Deferred<Unit> =
            CoroutineScope(Dispatchers.IO).async {
                // Delay for check the progress ( Draft )
                delay(1500)
                val result = repoSource.loadMoreAsync().await()
                if (result.isSucces()) {
                    repoSource.saveAll(result.value!!)
                } else {
                    throw result.error
                }
                return@async
            }
    }
}