package net.ozero.githubapp.data.repo.remote

import com.google.gson.annotations.SerializedName
import net.ozero.githubapp.data.repo.DataMapper
import net.ozero.githubapp.entity.Repo

data class RepoRemoteModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val repoName: String,
    @SerializedName("login")
    val ownerName: String
) : DataMapper<RepoRemoteModel, Repo> {

    override fun mapToDomain(): Repo = Repo(id, repoName, ownerName)
}

fun Repo.toRemoteModel() = RepoRemoteModel(id, repoName, ownerName)