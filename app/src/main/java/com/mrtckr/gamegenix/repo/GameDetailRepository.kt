package com.mrtckr.gamegenix.repo

import com.mrtckr.gamegenix.api.IRetrofit
import com.mrtckr.gamegenix.common.ResultData
import com.mrtckr.gamegenix.model.gamedetail.GameDetail
import com.mrtckr.gamegenix.model.games.Game
import java.lang.Exception
import javax.inject.Inject

class GameDetailRepository @Inject constructor(
    private val retrofitApi: IRetrofit
): IGameDetailRepository {
    override suspend fun getGame(gameId: Int): ResultData<GameDetail> {
        return try {
            val response = retrofitApi.getGameDetail(gameId)
            if (response.isSuccessful){
                response.body()?.let {
                    return@let ResultData.Success(it)
                } ?: ResultData.Failed()
            }
            else{
                ResultData.Failed()
            }
        }
        catch (e:Exception){
            println("mcmc" +e.message.toString())
            ResultData.Failed()
        }
    }
}