package net.ozero.githubapp.data.profile.remote

import com.google.gson.annotations.SerializedName
import net.ozero.githubapp.data.DataMapper
import net.ozero.githubapp.data.api.API_DATE_PATTERN
import net.ozero.githubapp.entity.Profile
import java.text.SimpleDateFormat
import java.util.*

data class ProfileRemoteModel(
    @SerializedName("login")
    val login: String = "",
    @SerializedName("avatar_url")
    val avatarUrl: String = "",
    @SerializedName("created_at")
    val createdAt: String = ""
) : DataMapper<Profile> {

    override fun mapToDomain(): Profile {

        return Profile(
            login,
            avatarUrl,
            SimpleDateFormat(API_DATE_PATTERN, Locale.getDefault())
                .parse(createdAt) ?: Date()
        )
    }
}