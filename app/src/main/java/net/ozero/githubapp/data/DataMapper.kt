package net.ozero.githubapp.data

interface DataMapper<TDomain> {

    fun mapToDomain() : TDomain
}