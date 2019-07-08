package net.ozero.githubapp.data.api

import kotlinx.coroutines.Deferred
import net.ozero.githubapp.data.profile.remote.ProfileRemoteModel
import net.ozero.githubapp.data.repo.remote.RepoRemoteModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("/repositories")
    fun reposAsync() : Deferred<Response<List<RepoRemoteModel>>>

    @GET("/users/$MY_GIT_HUB_LOGIN")
    fun profileAsync() : Deferred<Response<ProfileRemoteModel>>
}