package com.mrtckr.gamegenix.api

import com.mrtckr.gamegenix.model.Game
import com.mrtckr.gamegenix.util.Util.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface IRetrofit {
    @Headers("X-RapidAPI-Key: defb7e6f56msh8b85de4b398a3b0p1e4319jsn38afecee7dd5")
    @GET("/games")
    suspend fun getGames(): Response<Game>
}