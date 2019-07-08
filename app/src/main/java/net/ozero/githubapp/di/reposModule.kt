package net.ozero.githubapp.di

import net.ozero.githubapp.data.database.RoomAppDatabase
import net.ozero.githubapp.data.repo.RepoSourceImpl
import net.ozero.githubapp.data.repo.local.RepoDao
import net.ozero.githubapp.usecase.repos.*
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.singleton

val repoModule = Kodein.Module("repo") {

    bind<RepoDao>() with singleton {
        instance<RoomAppDatabase>().repoDao()
    }

    bind<RepoSource>() with singleton {
        RepoSourceImpl(instance(), instance())
    }

    bind<ObserveReposUseCase>() with singleton {
        ObserveReposUseCase.Impl(instance())
    }

    bind<LoadMoreReposUseCase>() with singleton {
        LoadMoreReposUseCase.ImplDraft(instance())
    }
}