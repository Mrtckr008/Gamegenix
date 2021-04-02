package com.mrtckr.gamegenix.api

import com.mrtckr.gamegenix.model.Game
import com.mrtckr.gamegenix.model.genres.GenresDetail
import com.mrtckr.gamegenix.util.Util.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface IRetrofit {
    @Headers("key: 20ed3030b4544ac88f56e71e66ac9317")
    @GET("games")
    suspend fun getGames(@Query("page") page: Int,
                         @Query("search") search: String,
                         @Query("ordering") ordering: String
                         ): Response<Game>

    @Headers("key: 20ed3030b4544ac88f56e71e66ac9317")
    @GET("genres")
    suspend fun getGenres(): Response<GenresDetail>
}