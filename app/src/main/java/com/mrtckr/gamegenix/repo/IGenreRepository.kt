package com.mrtckr.gamegenix.repo

import com.mrtckr.gamegenix.common.ResultData
import com.mrtckr.gamegenix.model.genres.GenresDetail

interface IGenreRepository {

    suspend fun getGenres(): ResultData<GenresDetail>

}