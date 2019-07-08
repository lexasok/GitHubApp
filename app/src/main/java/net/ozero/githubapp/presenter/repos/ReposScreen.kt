package net.ozero.githubapp.presenter.repos

import androidx.lifecycle.Observer
import net.ozero.githubapp.entity.Repo
import net.ozero.githubapp.presenter.base.BasePresenter
import net.ozero.githubapp.presenter.base.BaseView
import net.ozero.githubapp.usecase.repos.LoadMoreReposUseCase
import net.ozero.githubapp.usecase.repos.ObserveReposUseCase
import org.kodein.di.erased.instance

class RepoPresenter(private val view: ReposView) : BasePresenter(view) {

    private val repos by instance<ObserveReposUseCase>()
    private val loadMoreRepos by instance<LoadMoreReposUseCase>()

    override fun onCreate() {
        super.onCreate()
        executor.executeObservable(repos) {
            it.await().observe(view, Observer {repos ->
                view.repos = repos
            })
        }
        executor.execute(loadMoreRepos) {}
    }
}

interface ReposView : BaseView {
    var repos: List<Repo>
}