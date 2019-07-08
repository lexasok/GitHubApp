package net.ozero.githubapp.data.repo.remote

import kotlinx.coroutines.Deferred
import net.ozero.githubapp.entity.Repo
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("/repositories")
    fun reposAsync() : Deferred<Response<List<RepoRemoteModel>>>
}