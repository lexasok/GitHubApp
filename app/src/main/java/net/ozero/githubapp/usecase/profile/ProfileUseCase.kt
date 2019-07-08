package net.ozero.githubapp.usecase.profile

import kotlinx.coroutines.*
import net.ozero.githubapp.entity.Profile
import net.ozero.githubapp.usecase.UseCase

interface ProfileUseCase : UseCase<Profile> {

    class Impl(private val profileSource: ProfileSource) : ProfileUseCase {

        override suspend fun executeAsync(): Deferred<Profile> =
            CoroutineScope(Dispatchers.IO).async {
                val result = profileSource.profileAsync().await()
                if (result.isSucces()) {
                    result.value!!
                } else {
                    throw result.error
                }
            }

    }
}