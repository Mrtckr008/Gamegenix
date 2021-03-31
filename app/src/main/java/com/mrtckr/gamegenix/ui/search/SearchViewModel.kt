package com.mrtckr.gamegenix.ui.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mrtckr.gamegenix.common.BaseViewModel
import com.mrtckr.gamegenix.common.ResultData
import com.mrtckr.gamegenix.model.Game
import com.mrtckr.gamegenix.repo.IGameRepository
import kotlinx.coroutines.launch

class SearchViewModel @ViewModelInject constructor(private val repository: IGameRepository): BaseViewModel() {
    private val games = MutableLiveData<ResultData<Game>>()
    val gameList: LiveData<ResultData<Game>>
        get() = games

    fun getGames(page: Int, query: String) {
        games.value = ResultData.Loading()
        viewModelScope.launch {
            val response = repository.getGames(page, query)
            games.postValue(response)
        }
    }
}