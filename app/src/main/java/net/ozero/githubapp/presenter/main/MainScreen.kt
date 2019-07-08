package net.ozero.githubapp.presenter.main

import net.ozero.githubapp.presenter.base.BasePresenter
import net.ozero.githubapp.presenter.base.BaseView

class MainPresenter(private val view: MainView) : BasePresenter(view)

interface MainView : BaseView {}