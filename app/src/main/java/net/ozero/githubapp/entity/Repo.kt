package net.ozero.githubapp.entity

data class Repo(
    val id: Long,
    val repoName: String,
    val ownerName: String,
    val description: String = ""
)