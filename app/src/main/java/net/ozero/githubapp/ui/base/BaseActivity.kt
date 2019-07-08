package net.ozero.githubapp.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.ozero.githubapp.presenter.base.BasePresenter

abstract class BaseActivity<T: BasePresenter> : AppCompatActivity() {

    lateinit var presenter: T

    abstract fun initPresenter(): T

    abstract fun layoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        presenter = initPresenter()
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}