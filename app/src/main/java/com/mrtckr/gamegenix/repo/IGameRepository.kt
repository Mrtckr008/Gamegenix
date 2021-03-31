package com.mrtckr.gamegenix.repo

import androidx.lifecycle.LiveData
import com.mrtckr.gamegenix.common.ResultData
import com.mrtckr.gamegenix.model.Game

interface IGameRepository {

    suspend fun getGames(page: Int, query:String, sortingKeyword: String): ResultData<Game>
}