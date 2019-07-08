package net.ozero.githubapp.presenter.profile

import net.ozero.githubapp.presenter.base.BasePresenter
import net.ozero.githubapp.presenter.base.BaseView

class ProfilePresenter(private val view: ProfileView) : BasePresenter(view) {


    override fun onCreate() {
        super.onCreate()
    }
}

interface ProfileView : BaseView {
}