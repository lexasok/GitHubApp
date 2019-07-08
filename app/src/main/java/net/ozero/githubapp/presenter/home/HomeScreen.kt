package net.ozero.githubapp.presenter.home

import net.ozero.githubapp.presenter.base.BasePresenter
import net.ozero.githubapp.presenter.base.BaseView

class HomePresenter(private val view: HomeView) : BasePresenter(view)  {}

interface HomeView : BaseView {}