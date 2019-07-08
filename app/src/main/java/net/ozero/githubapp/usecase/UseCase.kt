package net.ozero.githubapp.usecase

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Deferred

// TODO add params
interface UseCase<T> {

    suspend fun executeAsync(): Deferred<T>
}

// TODO add params
interface ObservableUseCase<T> {

    suspend fun executeAsync(): Deferred<LiveData<T>>
}