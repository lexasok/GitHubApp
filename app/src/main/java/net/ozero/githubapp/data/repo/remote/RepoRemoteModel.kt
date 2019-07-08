package net.ozero.githubapp.data.repo.remote

import com.google.gson.annotations.SerializedName
import net.ozero.githubapp.data.DataMapper
import net.ozero.githubapp.entity.Repo

data class RepoRemoteModel(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("name")
    val repoName: String = "",
    @SerializedName("owner")
    val owner: Owner,
    @SerializedName("description")
    val description: String?
) : DataMapper<Repo> {

    override fun mapToDomain(): Repo = Repo(
        id,
        repoName,
        owner.login,
        description ?: ""
    )
}

fun Repo.toRemoteModel() = RepoRemoteModel(id, repoName, Owner(ownerName), description)

data class Owner(
    @SerializedName("login")
    val login: String = ""
)