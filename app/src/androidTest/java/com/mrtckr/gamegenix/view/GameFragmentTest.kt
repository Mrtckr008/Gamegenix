package com.mrtckr.gamegenix.view

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.MediumTest
import com.mrtckr.gamegenix.R
import com.mrtckr.gamegenix.launchFragmentInHiltContainer
import com.mrtckr.gamegenix.repo.FakeGameRepositoryAndroid
import com.mrtckr.gamegenix.ui.GamegenixFragmentFactory
import com.mrtckr.gamegenix.ui.home.HomeFragment
import com.mrtckr.gamegenix.ui.home.HomeFragmentDirections
import com.mrtckr.gamegenix.ui.home.HomeViewModel
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
class GameFragmentTest {
    private lateinit var viewModel: HomeViewModel

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var fragmentFactory : GamegenixFragmentFactory

    @Before
    fun setup(){
        viewModel = HomeViewModel(FakeGameRepositoryAndroid())
        hiltRule.inject()
    }

    @Test
    fun testNavigationFromHomeToSearch(){
        val navController = Mockito.mock(NavController::class.java)

        launchFragmentInHiltContainer<HomeFragment>(
            factory = fragmentFactory
        ) {
            Navigation.setViewNavController(requireView(),navController)
        }
        Espresso.onView(ViewMatchers.withId(R.id.search_card_view)).perform(ViewActions.click())

        Mockito.verify(navController).navigate(
            R.id.action_navigation_home_to_searchFragment,null,null,null
        )
        // TODO: If you want to use this test, you must change this part of code in HomeFragment like that ->
        //  findNavController().navigate(
        //                R.id.action_navigation_home_to_searchFragment,null,null,null /*this parameter must be null*/ )
    }
}