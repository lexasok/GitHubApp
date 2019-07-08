package net.ozero.githubapp.presenter.main

import net.ozero.githubapp.presenter.base.BasePresenter
import net.ozero.githubapp.presenter.base.BaseView

// TODO implement progress spinner!
class MainPresenter(private val view: MainView) : BasePresenter(view) {

    fun loading(loading: Boolean) {

    }
}

interface MainView : BaseView {

    fun showLoading()

    fun stopLoading()
}