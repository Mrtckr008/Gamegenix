package com.mrtckr.gamegenix.api

import com.mrtckr.gamegenix.model.gamedetail.GameDetail
import com.mrtckr.gamegenix.model.games.Game
import com.mrtckr.gamegenix.model.genres.GenresDetail
import com.mrtckr.gamegenix.util.Util.API_KEY
import retrofit2.Response
import retrofit2.http.*

interface IRetrofit {
    @Headers("key: $API_KEY")
    @GET("games")
    suspend fun getGames(@Query("page") page: Int,
                         @Query("search") search: String,
                         @Query("ordering") ordering: String
                         ): Response<Game>

    @Headers("key: $API_KEY")
    @GET("genres")
    suspend fun getGenres(): Response<GenresDetail>

    @Headers("key: $API_KEY")
    @GET("games/{game_id}")
    suspend fun getGameDetail(
        @Path(value = "game_id", encoded = true) game_id: Int,
    ): Response<GameDetail>
}