package net.ozero.githubapp.entity

data class Result<out T>(val value: T? = null, val error: Throwable = BaseError()) {

    fun isSuccess() = value != null
}