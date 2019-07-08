package net.ozero.githubapp.usecase.profile

import kotlinx.coroutines.Deferred
import net.ozero.githubapp.entity.Profile
import net.ozero.githubapp.entity.Result

interface ProfileSource {

    suspend fun profileAsync() : Deferred<Result<Profile>>
}