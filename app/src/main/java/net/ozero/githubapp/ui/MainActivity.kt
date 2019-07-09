package net.ozero.githubapp.ui

import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.fragment_home.*
import net.ozero.githubapp.R
import net.ozero.githubapp.presenter.main.MainPresenter
import net.ozero.githubapp.presenter.main.MainView
import net.ozero.githubapp.ui.base.BaseActivity

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    override fun initPresenter(): MainPresenter = MainPresenter(this)

    override fun layoutId(): Int = R.layout.activity_main

    override fun showError(error: Throwable) {}

    override fun initView() {

        val navController = Navigation
            .findNavController(this, R.id.main_nav_host)
        main_bottom_navigation.setupWithNavController(navController)
    }
}
