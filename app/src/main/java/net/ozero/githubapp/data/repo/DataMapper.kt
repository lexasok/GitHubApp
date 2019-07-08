package net.ozero.githubapp.data.repo

interface DataMapper<TData, TDomain> {

    fun mapToDomain() : TDomain
}