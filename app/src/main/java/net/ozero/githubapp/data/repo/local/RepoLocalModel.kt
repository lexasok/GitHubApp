package net.ozero.githubapp.data.repo.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import net.ozero.githubapp.data.repo.DataMapper
import net.ozero.githubapp.entity.Repo

@Entity
data class RepoLocalModel(
    @PrimaryKey
    val id: Int,
    val repoName: String,
    val ownerName: String
) : DataMapper<RepoLocalModel, Repo> {

    override fun mapToDomain(): Repo = Repo(id, repoName, ownerName)
}

fun Repo.toLocalModel() = RepoLocalModel(id, repoName, ownerName)