package com.mrtckr.gamegenix.common

/**
 * @author wooz
 * @since 09/10/2020
 */
sealed class ResultData<out T> {
    data class Loading(val nothing: Nothing? = null) : ResultData<Nothing>()
    data class Success<out T>(val data: T? = null) : ResultData<T>()
    data class Failed(val error: String? = null) : ResultData<Nothing>()

    fun toData(): T? = if(this is Success) this.data else null
}