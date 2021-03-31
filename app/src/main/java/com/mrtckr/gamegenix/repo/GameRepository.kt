package com.mrtckr.gamegenix.repo

import com.mrtckr.gamegenix.api.IRetrofit
import com.mrtckr.gamegenix.common.ResultData
import com.mrtckr.gamegenix.model.Game
import java.lang.Exception
import javax.inject.Inject

class GameRepository @Inject constructor(
    private val retrofitApi: IRetrofit
): IGameRepository {
    override suspend fun getGames(page: Int,query:String): ResultData<Game> {
        return try {
            val response = retrofitApi.getGames(page,query)
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