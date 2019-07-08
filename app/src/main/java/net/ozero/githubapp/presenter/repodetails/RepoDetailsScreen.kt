package net.ozero.githubapp.presenter.repodetails

import net.ozero.githubapp.entity.Repo
import net.ozero.githubapp.presenter.base.BasePresenter
import net.ozero.githubapp.presenter.base.BaseView

class RepoDetailsPresenter(private val view: RepoDetailsView) : BasePresenter(view) {

    override fun onCreate() {
        super.onCreate()
    }
}

interface RepoDetailsView : BaseView {
    var repo: Repo
}