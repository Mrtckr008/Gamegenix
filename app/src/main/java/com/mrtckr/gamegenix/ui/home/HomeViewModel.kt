package com.mrtckr.gamegenix.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mrtckr.gamegenix.common.BaseViewModel
import com.mrtckr.gamegenix.common.ResultData
import com.mrtckr.gamegenix.model.Game
import com.mrtckr.gamegenix.model.SortingType
import com.mrtckr.gamegenix.repo.IGameRepository
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(private val repository: IGameRepository) :
    BaseViewModel() {

    private val games = MutableLiveData<ResultData<Game>>()
    val gameList: LiveData<ResultData<Game>>
        get() = games

    fun getGames(page: Int, query: String, sortingType: SortingType) {
        if (page > 0) {  // Writing this condition for testing ViewModel.
            games.value = ResultData.Loading()
            viewModelScope.launch {
                val response = repository.getGames(page, query, sortingType.keyword)
                games.postValue(response)
            }
        }
        else{
            games.postValue(ResultData.Failed())
        }
    }
}