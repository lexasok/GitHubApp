package net.ozero.githubapp.di

import net.ozero.githubapp.data.profile.remote.ProfileSourceImpl
import net.ozero.githubapp.usecase.profile.ProfileSource
import net.ozero.githubapp.usecase.profile.ProfileUseCase
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.singleton

val profileModule = Kodein.Module("profile") {

    bind<ProfileSource>() with singleton {
        ProfileSourceImpl(instance())
    }

    bind<ProfileUseCase>() with singleton {
        ProfileUseCase.Impl(instance())
    }
}