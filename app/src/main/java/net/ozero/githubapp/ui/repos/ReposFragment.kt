package net.ozero.githubapp.ui.repos

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_repos.*
import net.ozero.githubapp.R
import net.ozero.githubapp.entity.Repo
import net.ozero.githubapp.presenter.repos.RepoPresenter
import net.ozero.githubapp.presenter.repos.ReposView
import net.ozero.githubapp.ui.MainActivity
import net.ozero.githubapp.ui.base.BaseFragment
import net.ozero.githubapp.ui.listener.OnScrolldedToBottomListener
import net.ozero.githubapp.ui.repos.adapter.RepoAdapter

class ReposFragment : BaseFragment<RepoPresenter>(), ReposView {

    private lateinit var adapter: RepoAdapter
    private lateinit var controller: NavController

    override fun navigateRepoDetails(id: Long) {
        val args = Bundle()
        args.putLong(resources.getString(R.string.key_repo_id), id)
        controller.navigate(
            R.id.action_homeFragment_to_reposDetailsFragment,
            args
        )
    }

    override var repos: List<Repo> = mutableListOf()
        set(value) {
            adapter.update(value)
            repos_list.scrollToPosition(repos.size)
            field = value
        }

    override var loading: Boolean = false
        set(value) {
            if (value) {
                activity?.main_progress?.visibility = View.VISIBLE
            } else {
                activity?.main_progress?.visibility = View.GONE
            }
            field = value
        }

    override fun initPresenter(): RepoPresenter = RepoPresenter(this)

    override fun layoutId(): Int = R.layout.fragment_repos

    override fun showError(error: Throwable) {}

    override fun initView() {
        controller =  Navigation
            .findNavController(activity as MainActivity, R.id.main_nav_host)
        adapter = RepoAdapter(presenter::onRepoPressed)
        repos_list.layoutManager = LinearLayoutManager(repos_list.context)
        repos_list.adapter = adapter
        repos_list.addOnScrollListener(OnScrolldedToBottomListener(presenter::onScrolledToBottom))
    }

    override fun showMenu() {
        activity?.main_bottom_navigation?.visibility = View.VISIBLE
    }
}
