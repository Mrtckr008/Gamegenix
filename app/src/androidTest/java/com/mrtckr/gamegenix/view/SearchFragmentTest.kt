package com.mrtckr.gamegenix.view

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.filters.MediumTest
import com.mrtckr.gamegenix.launchFragmentInHiltContainer
import com.mrtckr.gamegenix.repo.FakeGameRepositoryAndroid
import com.mrtckr.gamegenix.ui.GamegenixFragmentFactory
import com.mrtckr.gamegenix.ui.home.HomeViewModel
import com.mrtckr.gamegenix.ui.search.SearchFragment
import com.mrtckr.gamegenix.ui.search.SearchViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import javax.inject.Inject

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class SearchFragmentTest {
    private lateinit var viewModel: SearchViewModel

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var fragmentFactory : GamegenixFragmentFactory

    @Before
    fun setup(){
        viewModel = SearchViewModel(FakeGameRepositoryAndroid())
        hiltRule.inject()
    }

    @Test
    fun testOnBackPressed() {
        val navController = Mockito.mock(NavController::class.java)
        launchFragmentInHiltContainer<SearchFragment>(
            factory = fragmentFactory
        ) {
            Navigation.setViewNavController(requireView(),navController)
        }

        Espresso.pressBack()
        Mockito.verify(navController).popBackStack()
    }
}