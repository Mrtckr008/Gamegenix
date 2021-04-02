package com.mrtckr.gamegenix.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.mrtckr.gamegenix.MainCoroutineRule
import com.mrtckr.gamegenix.common.ResultData
import com.mrtckr.gamegenix.getOrAwaitValueTest
import com.mrtckr.gamegenix.model.games.SortingType
import com.mrtckr.gamegenix.repo.FakeGameRepository
import com.mrtckr.gamegenix.ui.home.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest  {

    private lateinit var viewModel: HomeViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setup(){
        viewModel = HomeViewModel(FakeGameRepository())
    }

    @Test
    fun `call game with page is less than 1`(){
        viewModel.getGames(0,"", SortingType.Popularity)
        val value = viewModel.gameList.getOrAwaitValueTest()
        assertThat(value).isEqualTo(ResultData.Failed())
    }

    @Test
    fun `call game with page is more than 0`(){
        viewModel.getGames(3,"", SortingType.Popularity)
        val value = viewModel.gameList.getOrAwaitValueTest()
        assertThat(value).isNotEqualTo(ResultData.Failed())
    }

}