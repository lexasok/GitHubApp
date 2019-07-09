package net.ozero.githubapp.presenter.base

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import net.ozero.githubapp.App
import net.ozero.githubapp.presenter.executor.UseCaseExecutor
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.erased.instance

abstract class BasePresenter(private val view: BaseView) : KodeinAware {

    val executor: UseCaseExecutor by instance(arg = this)
    var loading: Boolean = false
        set(value) {
            view.loading = value
            field = value
        }

    override val kodein: Kodein
        get() = App.kodein()

    open fun onCreate(arguments: Bundle? = null) {
        view.initView()
        if (view is HiddenMenuScreen) {
            view.hideMenu()
        } else {
            view.showMenu()
        }
        view.loading = loading
    }

    fun onDestroy() {
        loading = false
        executor.cancel()
    }

    open fun onError(error: Throwable) {
        view.showError(error)
        error.printStackTrace()
    }
}

interface BaseView: LifecycleOwner {

    fun showMenu()

    fun initView()

    fun showError(error: Throwable)

    var loading: Boolean
}