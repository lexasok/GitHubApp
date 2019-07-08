package net.ozero.githubapp.presenter.repodetails

import android.content.res.Resources
import android.os.Bundle
import androidx.lifecycle.Observer
import net.ozero.githubapp.R
import net.ozero.githubapp.entity.Repo
import net.ozero.githubapp.entity.WrongDataError
import net.ozero.githubapp.presenter.base.BasePresenter
import net.ozero.githubapp.presenter.base.BaseView
import net.ozero.githubapp.usecase.repos.ObserveRepoByIdUseCase
import org.kodein.di.erased.instance

class RepoDetailsPresenter(private val view: RepoDetailsView, private val resources: Resources) : BasePresenter(view) {

    private val observeRepoByIdUseCase by instance<ObserveRepoByIdUseCase>()

    override fun onCreate(arguments: Bundle?) {
        super.onCreate(arguments)
        val id = arguments
            ?.getLong(resources.getString(R.string.key_repo_id), 0L) ?: 0L

        if (arguments != null && id  > 0) {
            executor.executeParamsObservable(observeRepoByIdUseCase, id) {
                it.await().observe(view, Observer {repo ->
                    val repo = repo
                    view.repo = repo
                })
            }
        } else {
            view.showError(WrongDataError(resources.getString(R.string.error_wrong_data)))
        }
    }

    fun onBackButtonPressed() {
        view.back()
    }
}

interface RepoDetailsView : BaseView {

    var repo: Repo?

    fun back()
}