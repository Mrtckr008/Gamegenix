package com.mrtckr.gamegenix.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.mrtckr.gamegenix.ui.detail.DetailFragment
import com.mrtckr.gamegenix.ui.detail.adapter.GamePlatformsAdapter
import com.mrtckr.gamegenix.ui.detail.adapter.GameStoresAdapter
import com.mrtckr.gamegenix.ui.home.GameRecyclerAdapter
import com.mrtckr.gamegenix.ui.home.HomeFragment
import com.mrtckr.gamegenix.ui.genres.GenresFragment
import com.mrtckr.gamegenix.ui.genres.adapter.GenresGameRecyclerAdapter
import com.mrtckr.gamegenix.ui.genres.adapter.GenresSectionedAdapter
import com.mrtckr.gamegenix.ui.search.SearchFragment
import javax.inject.Inject

class GamegenixFragmentFactory @Inject constructor(
    private val gameRecyclerAdapter: GameRecyclerAdapter,
    private val genresGameRecyclerAdapter: GenresGameRecyclerAdapter,
    private val genresSectionedAdapter: GenresSectionedAdapter,
    private val platformRecyclerAdapter: GamePlatformsAdapter,
    private val storeGameRecyclerAdapter: GameStoresAdapter,
    private val glide : RequestManager
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            HomeFragment::class.java.name -> HomeFragment(gameRecyclerAdapter)
            GenresFragment::class.java.name -> GenresFragment(genresGameRecyclerAdapter,genresSectionedAdapter)
            SearchFragment::class.java.name -> SearchFragment(gameRecyclerAdapter)
            DetailFragment::class.java.name -> DetailFragment(glide,platformRecyclerAdapter,storeGameRecyclerAdapter)
            else -> super.instantiate(classLoader, className)
        }
    }
}