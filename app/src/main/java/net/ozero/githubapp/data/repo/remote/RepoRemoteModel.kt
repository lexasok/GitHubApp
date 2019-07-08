package net.ozero.githubapp.data.repo.remote

import com.google.gson.annotations.SerializedName
import net.ozero.githubapp.data.repo.DataMapper
import net.ozero.githubapp.entity.Repo

data class RepoRemoteModel(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val repoName: String = "",
    @SerializedName("owner")
    val owner: Owner
) : DataMapper<RepoRemoteModel, Repo> {

    override fun mapToDomain(): Repo = Repo(
        id,
        repoName,
        owner.login
    )
}

fun Repo.toRemoteModel() = RepoRemoteModel(id, repoName, Owner(ownerName))

data class Owner(
    @SerializedName("login")
    val login: String = ""
)