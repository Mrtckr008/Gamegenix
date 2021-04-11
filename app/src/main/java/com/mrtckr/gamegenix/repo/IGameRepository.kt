package com.mrtckr.gamegenix.repo

import com.mrtckr.gamegenix.common.ResultData
import com.mrtckr.gamegenix.model.games.Game

interface IGameRepository {
    suspend fun getGames(page: Int, query:String, sortingKeyword: String): ResultData<Game>
}