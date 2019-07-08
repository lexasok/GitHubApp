package net.ozero.githubapp.data.profile.remote

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import net.ozero.githubapp.data.api.ApiClient
import net.ozero.githubapp.entity.InternetError
import net.ozero.githubapp.entity.Profile
import net.ozero.githubapp.entity.Result
import net.ozero.githubapp.usecase.profile.ProfileSource

class ProfileSourceImpl(private val apiClient: ApiClient) : ProfileSource {

    override suspend fun profileAsync(): Deferred<Result<Profile>> = CoroutineScope(Dispatchers.IO).async {
        val response = apiClient.profileAsync().await()
        val body = response.body()

        // TODO try to bring to Consumer
        if (response.isSuccessful && body != null) {
            val result = body.mapToDomain()
            Result(result)
        } else {
            Result(error = InternetError(response.message()))
        }
    }
}