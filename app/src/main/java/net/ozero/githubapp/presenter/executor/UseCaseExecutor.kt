package net.ozero.githubapp.presenter.executor

import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.*
import net.ozero.githubapp.presenter.error.ErrorHandler
import net.ozero.githubapp.usecase.ObservableUseCase
import net.ozero.githubapp.usecase.UseCase

// TODO add loading state
class UseCaseExecutor(
    private val scope: CoroutineScope,
    private val onError: (Throwable) -> Unit,
    private val errorHandler: ErrorHandler
) {

    private var job: Job? = null

    // TODO add params
    fun <TEntity>execute(useCase: UseCase<TEntity>, action: suspend (Deferred<TEntity>) -> Unit) {
        job = scope.launch {
            try {
                val deferred = useCase.executeAsync()
                action(deferred)
            } catch (e: CancellationException) {
                Log.i("$useCase" ,"cancelled")
            } catch (e: Throwable) {
                e.printStackTrace()
                try {
                    onError(e)
                } catch (e: Throwable) {
                    errorHandler.handle(e)
                }
            }
        }
    }

    // TODO add params
    fun <TEntity>executeObservable(
        useCase: ObservableUseCase<TEntity>,
        action: suspend (Deferred<LiveData<TEntity>>) -> Unit
    ) {
        job = scope.launch {
            try {
                val deferred = useCase.executeAsync()
                action(deferred)
            } catch (e: CancellationException) {
                Log.i("$useCase" ,"cancelled")
            } catch (e: Throwable) {
                e.printStackTrace()
                try {
                    onError(e)
                } catch (e: Throwable) {
                    errorHandler.handle(e)
                }
            }
        }
    }

    fun cancel() {
        job?.cancel()
        job = null
    }
}