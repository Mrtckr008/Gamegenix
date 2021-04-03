package com.mrtckr.gamegenix.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrtckr.gamegenix.R
import com.mrtckr.gamegenix.common.BaseFragment
import com.mrtckr.gamegenix.databinding.FragmentHomeBinding
import com.mrtckr.gamegenix.model.games.GameResult
import com.mrtckr.gamegenix.model.games.SortingType
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment @Inject constructor(
    private val gameRecyclerAdapter: GameRecyclerAdapter)
    : BaseFragment<HomeViewModel, FragmentHomeBinding>(){

    override val layoutRes: Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    private var paginationCounter = 1
    private var gameList : ArrayList<GameResult> = arrayListOf()
    override fun observeViewModel() {
        viewModel.gameList.observe(viewLifecycleOwner, Observer {resultData ->
            resultData.toData()?.results?.let { result -> gameList.addAll(result) }
            gameRecyclerAdapter.gameResult = gameList
            gameRecyclerAdapter.notifyDataSetChanged()
        })
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getGames(paginationCounter,"",
            SortingType.Default)
        binding.gameListRecyclerView.adapter = gameRecyclerAdapter
        binding.gameListRecyclerView.layoutManager = GridLayoutManager(requireContext(),2)

        gameRecyclerAdapter.setOnItemClickListener {

        }

        binding.gameListRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    viewModel.getGames(++paginationCounter,"",
                        SortingType.Default)
                }
            }
        })

        binding.searchCardView.setOnClickListener {
            val extras = FragmentNavigatorExtras(
                binding.searchCardView to "transition_name"
            )
            findNavController().navigate(
                R.id.action_navigation_home_to_searchFragment,null,null,extras
            )
        }
    }

    override fun onDestroyView() {
        gameList.clear()
        super.onDestroyView()
    }

    override fun onResume() {
        super.onResume()
        setToolbarTitle(this.requireContext().getString(R.string.app_name))
        setToolbarBackButtonVisibility(View.GONE)
    }
}