package net.ozero.githubapp.data.api

import kotlinx.coroutines.Deferred
import net.ozero.githubapp.data.profile.remote.ProfileRemoteModel
import net.ozero.githubapp.data.repo.remote.RepoRemoteModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("/repositories")
    fun reposAsync(
        @Query("since") lastRepoId: Long
    ) : Deferred<Response<List<RepoRemoteModel>>>

    @GET("/users/$MY_GIT_HUB_LOGIN")
    fun profileAsync() : Deferred<Response<ProfileRemoteModel>>
}