package net.ozero.githubapp.presenter.executor

import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.*
import net.ozero.githubapp.presenter.error.ErrorHandler
import net.ozero.githubapp.usecase.ObservableParamsUseCase
import net.ozero.githubapp.usecase.ObservableUseCase
import net.ozero.githubapp.usecase.UseCase

class UseCaseExecutor(
    private val scope: CoroutineScope,
    private val onError: (Throwable) -> Unit,
    private val errorHandler: ErrorHandler
) {

    private var allJobs = mutableListOf<Job>()

    fun <TEntity>execute(useCase: UseCase<TEntity>, action: suspend (Deferred<TEntity>) -> Unit) {
        val job = scope.launch {
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
        allJobs.add(job)
    }

    fun <TEntity>executeObservable(
        useCase: ObservableUseCase<TEntity>,
        action: suspend (Deferred<LiveData<TEntity>>) -> Unit
    ) {
        val job = scope.launch {
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
        allJobs.add(job)
    }

    fun <TEntity, TParams>executeParamsObservable(
        useCase: ObservableParamsUseCase<TEntity, TParams>,
        params: TParams,
        action: suspend (Deferred<LiveData<TEntity>>) -> Unit
    ) {
        val job = scope.launch {
            try {
                val deferred = useCase.executeAsync(params)
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
        allJobs.add(job)
    }

    fun cancel() {
        for (job in allJobs) {
            job.cancel()
        }
        allJobs.clear()
    }
}