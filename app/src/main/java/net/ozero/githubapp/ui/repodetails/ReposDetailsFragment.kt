package net.ozero.githubapp.ui.repodetails

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_repo_details.*
import net.ozero.githubapp.R
import net.ozero.githubapp.entity.Repo
import net.ozero.githubapp.presenter.base.HiddenMenuScreen
import net.ozero.githubapp.presenter.repodetails.RepoDetailsPresenter
import net.ozero.githubapp.presenter.repodetails.RepoDetailsView
import net.ozero.githubapp.ui.MainActivity
import net.ozero.githubapp.ui.base.BaseFragment

class ReposDetailsFragment :
    BaseFragment<RepoDetailsPresenter>(),
    RepoDetailsView,
    HiddenMenuScreen {

    private lateinit var controller: NavController

    override var repo: Repo? = null
        set(value) {
            repo_details_repo_name.text = value?.repoName ?: ""
            repo_details_description.text = value?.description ?: ""
            repo_details_owner_name.text = value?.ownerName ?: ""
            field = value
        }

    override fun initPresenter(): RepoDetailsPresenter = RepoDetailsPresenter(this, resources)

    override fun layoutId(): Int = R.layout.fragment_repo_details

    override fun showError(error: Throwable) {}

    override fun initView() {
        controller =  Navigation
            .findNavController(activity as MainActivity, R.id.main_nav_host)
        repo_details_button_back.setOnClickListener { presenter.onBackButtonPressed() }
    }

    override fun hideMenu() {
        activity!!.main_bottom_navigation?.visibility = View.GONE
    }

    override fun showMenu() {}

    override fun back() {
        controller.navigateUp()
    }
}
