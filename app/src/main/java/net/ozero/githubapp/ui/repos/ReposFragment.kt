package net.ozero.githubapp.ui.repos

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_repos.*
import net.ozero.githubapp.R
import net.ozero.githubapp.entity.Repo
import net.ozero.githubapp.presenter.repos.RepoPresenter
import net.ozero.githubapp.presenter.repos.ReposView
import net.ozero.githubapp.ui.base.BaseFragment
import net.ozero.githubapp.ui.repos.adapter.RepoAdapter

class ReposFragment : BaseFragment<RepoPresenter>(), ReposView {

    override var repos: List<Repo> = mutableListOf()
        set(value) {
            adapter.update(value)
            repos_list.scrollToPosition(repos.size)
            field = value
        }

    override fun initPresenter(): RepoPresenter = RepoPresenter(this)

    override fun layoutId(): Int = R.layout.fragment_repos

    override fun showError(error: Throwable) {}

    private val adapter = RepoAdapter()

    override fun initView() {

        repos_list.layoutManager = LinearLayoutManager(repos_list.context)
        repos_list.adapter = adapter
    }
}
