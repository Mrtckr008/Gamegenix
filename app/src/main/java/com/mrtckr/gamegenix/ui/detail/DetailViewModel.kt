package com.mrtckr.gamegenix.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mrtckr.gamegenix.common.BaseViewModel
import com.mrtckr.gamegenix.common.ResultData
import com.mrtckr.gamegenix.model.gamedetail.GameDetail
import com.mrtckr.gamegenix.model.genres.GenresDetail
import com.mrtckr.gamegenix.repo.IGameDetailRepository
import com.mrtckr.gamegenix.repo.IGenreRepository
import kotlinx.coroutines.launch

class DetailViewModel @ViewModelInject constructor(private val repository: IGameDetailRepository)  : BaseViewModel() {
    private val game = MutableLiveData<ResultData<GameDetail>>()
    val gameData: LiveData<ResultData<GameDetail>>
        get() = game

    fun getGame(gameId: Int) {
        game.value = ResultData.Loading()
        viewModelScope.launch {
            val response = repository.getGame(gameId)
            game.postValue(response)
        }
    }
}