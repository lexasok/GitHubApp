package net.ozero.githubapp.entity

import java.util.*

data class Profile(
    val login: String,
    val avatarUrl: String,
    val createdAt: Date
)