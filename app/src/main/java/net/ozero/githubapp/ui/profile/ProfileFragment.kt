package net.ozero.githubapp.ui.profile

import net.ozero.githubapp.R
import net.ozero.githubapp.presenter.profile.ProfilePresenter
import net.ozero.githubapp.presenter.profile.ProfileView
import net.ozero.githubapp.ui.base.BaseFragment

class ProfileFragment : BaseFragment<ProfilePresenter>(), ProfileView {


    override fun initPresenter(): ProfilePresenter = ProfilePresenter(this)

    override fun layoutId(): Int = R.layout.fragment_repos

    override fun showError(error: Throwable) {}


    override fun initView() {

    }
}
