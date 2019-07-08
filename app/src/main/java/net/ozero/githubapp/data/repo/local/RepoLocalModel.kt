package net.ozero.githubapp.data.repo.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import net.ozero.githubapp.data.DataMapper
import net.ozero.githubapp.entity.Repo

@Entity
data class RepoLocalModel(
    @PrimaryKey
    val id: Int,
    val repoName: String,
    val ownerName: String,
    val description: String
) : DataMapper<Repo> {

    override fun mapToDomain(): Repo = Repo(id, repoName, ownerName, description)
}

fun Repo.toLocalModel() = RepoLocalModel(id, repoName, ownerName, description)