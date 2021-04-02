package com.mrtckr.gamegenix.repo

import com.mrtckr.gamegenix.api.IRetrofit
import com.mrtckr.gamegenix.common.ResultData
import com.mrtckr.gamegenix.model.Game
import com.mrtckr.gamegenix.model.genres.GenresDetail
import com.mrtckr.gamegenix.model.genres.GenresGame
import java.lang.Exception
import javax.inject.Inject

class GenreRepository @Inject constructor(
    private val retrofitApi: IRetrofit
): IGenreRepository {
    override suspend fun getGenres(): ResultData<GenresDetail> {
        return try {
            val response = retrofitApi.getGenres()
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