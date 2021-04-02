package com.mrtckr.gamegenix.repo

import androidx.lifecycle.MutableLiveData
import com.mrtckr.gamegenix.common.ResultData
import com.mrtckr.gamegenix.model.games.Game

class FakeGameRepository: IGameRepository {
    private val gameData = Game()
    private val gameLiveData = MutableLiveData<Game>(gameData)

    override suspend fun getGames(
        page: Int,
        query: String,
        sortingKeyword: String
    ): ResultData<Game> {
        return ResultData.Success(gameData)
    }
}