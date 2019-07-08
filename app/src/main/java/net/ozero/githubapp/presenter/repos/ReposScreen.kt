package net.ozero.githubapp.presenter.repos

import androidx.lifecycle.Observer
import net.ozero.githubapp.entity.Repo
import net.ozero.githubapp.presenter.base.BasePresenter
import net.ozero.githubapp.presenter.base.BaseView
import net.ozero.githubapp.usecase.repos.LoadMoreReposUseCase
import net.ozero.githubapp.usecase.repos.ObserveReposUseCase
import org.kodein.di.erased.instance

// TODO save state
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

    fun onButtonAddPressed() {
        executor.execute(loadMoreRepos) {}
    }

    override fun onError(error: Throwable) {
        super.onError(error)
        view.showError(error)
        error.printStackTrace()
    }
}

interface ReposView : BaseView {
    var repos: List<Repo>
}