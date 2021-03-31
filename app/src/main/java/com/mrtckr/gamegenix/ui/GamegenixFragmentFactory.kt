package com.mrtckr.gamegenix.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.mrtckr.gamegenix.ui.dashboard.DashboardFragment
import com.mrtckr.gamegenix.ui.home.GameRecyclerAdapter
import com.mrtckr.gamegenix.ui.home.HomeFragment
import com.mrtckr.gamegenix.ui.notifications.NotificationsFragment
import com.mrtckr.gamegenix.ui.search.SearchFragment
import javax.inject.Inject

class GamegenixFragmentFactory @Inject constructor(
    private val gameRecyclerAdapter: GameRecyclerAdapter,
    private val glide : RequestManager
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            HomeFragment::class.java.name -> HomeFragment(gameRecyclerAdapter)
            NotificationsFragment::class.java.name -> NotificationsFragment()
            DashboardFragment::class.java.name -> DashboardFragment()
            SearchFragment::class.java.name -> SearchFragment(gameRecyclerAdapter)
            else -> super.instantiate(classLoader, className)
        }
    }
}