package com.mrtckr.gamegenix.repo

import com.mrtckr.gamegenix.common.ResultData
import com.mrtckr.gamegenix.model.gamedetail.GameDetail
import com.mrtckr.gamegenix.model.games.Game

interface IGameDetailRepository {
    suspend fun getGame(gameId: Int): ResultData<GameDetail>
}