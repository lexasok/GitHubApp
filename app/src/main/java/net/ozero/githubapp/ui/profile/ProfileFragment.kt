package net.ozero.githubapp.ui.profile

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_profile.*
import net.ozero.githubapp.R
import net.ozero.githubapp.entity.Profile
import net.ozero.githubapp.presenter.profile.ProfilePresenter
import net.ozero.githubapp.presenter.profile.ProfileView
import net.ozero.githubapp.ui.base.BaseFragment
import net.ozero.githubapp.ui.formatter.DateFormatter
import java.util.*

class ProfileFragment : BaseFragment<ProfilePresenter>(), ProfileView {

    private val dateFormatter = DateFormatter()

    override var profile: Profile? = null
    set(value) {
        profile_created_at.text = dateFormatter.format(value?.createdAt ?: Date())
        profile_login.text = value?.login ?: ""
        loadImage(value?.avatarUrl ?: "")
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

    override fun initPresenter(): ProfilePresenter = ProfilePresenter(this)

    override fun layoutId(): Int = R.layout.fragment_profile

    override fun initView() {}

    override fun showMenu() {
        activity?.main_bottom_navigation?.visibility = View.VISIBLE
    }

    private fun loadImage(url: String) {
        Glide.with(profile_avatar).load(url).into(profile_avatar)
    }
}
