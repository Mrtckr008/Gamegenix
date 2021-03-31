package com.mrtckr.gamegenix.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


open class BaseViewModel : ViewModel() {

    val loadingErrorState = MutableLiveData<ResultData<Any>>()

    fun handleTask(task: ResultData<Any>, callback: () -> Unit = {}) {
        loadingErrorState.postValue(task)
        callback.invoke()
    }
}