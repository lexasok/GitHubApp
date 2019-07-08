package net.ozero.githubapp.ui

import net.ozero.githubapp.R
import net.ozero.githubapp.presenter.main.MainPresenter
import net.ozero.githubapp.presenter.main.MainView
import net.ozero.githubapp.ui.base.BaseActivity

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    override fun initPresenter(): MainPresenter = MainPresenter(this)

    override fun layoutId(): Int = R.layout.activity_main

    override fun showError(error: Throwable) {}

    override fun initView() {}

    override fun showLoading() {}

    override fun stopLoading() {}
}
