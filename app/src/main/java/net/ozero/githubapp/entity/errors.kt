package net.ozero.githubapp.entity

open class BaseError : Throwable()

class InternetError(override val message: String) : BaseError()

class WrongDataError(override val message: String) : BaseError()