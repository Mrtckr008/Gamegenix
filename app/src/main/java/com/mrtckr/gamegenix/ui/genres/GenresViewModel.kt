package com.mrtckr.gamegenix.ui.genres

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mrtckr.gamegenix.common.BaseViewModel
import com.mrtckr.gamegenix.common.ResultData
import com.mrtckr.gamegenix.model.genres.GenresDetail
import com.mrtckr.gamegenix.repo.IGenreRepository
import kotlinx.coroutines.launch

class GenresViewModel @ViewModelInject constructor(private val repository: IGenreRepository) :
    BaseViewModel() {
    private val genres = MutableLiveData<ResultData<GenresDetail>>()
    val genresList: LiveData<ResultData<GenresDetail>>
        get() = genres

    fun getGenres() {
        viewModelScope.launch {
            val response = repository.getGenres()
            genres.postValue(response)
        }
    }
}