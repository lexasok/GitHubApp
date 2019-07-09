package net.ozero.githubapp.ui.home

import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.fragment_home.*
import net.ozero.githubapp.R
import net.ozero.githubapp.presenter.home.HomePresenter
import net.ozero.githubapp.presenter.home.HomeView
import net.ozero.githubapp.ui.MainActivity
import net.ozero.githubapp.ui.base.BaseFragment

class HomeFragment : BaseFragment<HomePresenter>(), HomeView {

    override fun initPresenter(): HomePresenter = HomePresenter(this)

    override fun layoutId(): Int = R.layout.fragment_home

    override fun initView() {

        val navController = Navigation
            .findNavController(activity as MainActivity, R.id.home_nav_host)
        main_bottom_navigation.setupWithNavController(navController)
    }

    override fun showError(error: Throwable) {}
}