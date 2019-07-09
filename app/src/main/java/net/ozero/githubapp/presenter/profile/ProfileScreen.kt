package net.ozero.githubapp.presenter.profile

import android.os.Bundle
import net.ozero.githubapp.entity.Profile
import net.ozero.githubapp.presenter.base.BasePresenter
import net.ozero.githubapp.presenter.base.BaseView
import net.ozero.githubapp.usecase.profile.ProfileUseCase
import org.kodein.di.erased.instance

class ProfilePresenter(private val view: ProfileView) : BasePresenter(view) {

    private val profile by instance<ProfileUseCase>()

    override fun onCreate(arguments: Bundle?) {
        super.onCreate(arguments)
        loading = true
        executor.execute(profile) {
            view.profile = it.await()
            loading = false
        }
    }
}

interface ProfileView : BaseView {

    var profile: Profile?
}