package net.ozero.githubapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.ozero.githubapp.presenter.base.BasePresenter

abstract class BaseFragment<T: BasePresenter> : Fragment() {

    lateinit var presenter: T

    abstract fun initPresenter(): T

    abstract fun layoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        LayoutInflater.from(container!!.context).inflate(layoutId(), container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = initPresenter()
        presenter.onCreate(arguments)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}