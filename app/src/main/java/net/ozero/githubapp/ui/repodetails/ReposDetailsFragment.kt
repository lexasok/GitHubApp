package net.ozero.githubapp.ui.repodetails

import kotlinx.android.synthetic.main.fragment_repo_details.*
import net.ozero.githubapp.R
import net.ozero.githubapp.entity.Repo
import net.ozero.githubapp.presenter.repodetails.RepoDetailsPresenter
import net.ozero.githubapp.presenter.repodetails.RepoDetailsView
import net.ozero.githubapp.ui.base.BaseFragment

class ReposDetailsFragment : BaseFragment<RepoDetailsPresenter>(), RepoDetailsView {

    override var repo: Repo? = null
        set(value) {
            repo_details_repo_name.text = repo?.repoName ?: ""
            repo_details_description.text = repo?.description ?: ""
            repo_details_owner_name.text = repo?.ownerName ?: ""
            field = value
        }

    override fun initPresenter(): RepoDetailsPresenter = RepoDetailsPresenter(this, resources)

    override fun layoutId(): Int = R.layout.fragment_repos

    override fun showError(error: Throwable) {}

    override fun initView() {

    }
}
