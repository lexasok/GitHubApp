package net.ozero.githubapp.presenter.repos

import android.os.Bundle
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

    override fun onCreate(arguments: Bundle?) {
        super.onCreate(arguments)
        executor.executeObservable(repos) {
            it.await().observe(view, Observer {repos ->
                view.repos = repos
            })
        }
        executor.execute(loadMoreRepos) {}
    }

    fun onRepoPressed(id: Long) {
        view.navigateRepoDetails(id)
    }
}

interface ReposView : BaseView {
    var repos: List<Repo>

    fun navigateRepoDetails(id: Long)
}