package net.ozero.githubapp.usecase

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Deferred

// TODO add params
interface UseCase<T> {

    suspend fun executeAsync(): Deferred<T>
}

// TODO add params
interface ObservableParamsUseCase<TResult, TParams> {

    suspend fun executeAsync(params: TParams): Deferred<LiveData<TResult>>
}

interface ObservableUseCase<TResult> {

    suspend fun executeAsync(): Deferred<LiveData<TResult>>
}