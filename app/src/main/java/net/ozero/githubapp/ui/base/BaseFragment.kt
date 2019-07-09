package net.ozero.githubapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import net.ozero.githubapp.presenter.base.BasePresenter
import net.ozero.githubapp.presenter.base.BaseView
import net.ozero.githubapp.presenter.base.HiddenMenuScreen

abstract class BaseFragment<T: BasePresenter> : Fragment(), BaseView {

    lateinit var presenter: T

    abstract fun initPresenter(): T

    abstract fun layoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(layoutId(), container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = initPresenter()
        presenter.onCreate(arguments)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showError(error: Throwable) {
        Toast.makeText(context!!, error.message, Toast.LENGTH_SHORT).show()
    }
}