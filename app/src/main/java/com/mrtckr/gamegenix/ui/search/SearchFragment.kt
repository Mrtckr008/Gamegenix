package com.mrtckr.gamegenix.ui.search

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrtckr.gamegenix.R
import com.mrtckr.gamegenix.common.BaseFragment
import com.mrtckr.gamegenix.common.hideKeyboard
import com.mrtckr.gamegenix.databinding.FragmentHomeBinding
import com.mrtckr.gamegenix.databinding.FragmentSearchBinding
import com.mrtckr.gamegenix.model.GameResult
import com.mrtckr.gamegenix.ui.home.GameRecyclerAdapter
import com.mrtckr.gamegenix.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment @Inject constructor(
    private val gameRecyclerAdapter: GameRecyclerAdapter
)
    : BaseFragment<SearchViewModel, FragmentSearchBinding>(){

    override val layoutRes: Int = R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()

    private var paginationCounter = 1
    private var lastQuery = ""
    private var gameList : ArrayList<GameResult> = arrayListOf()

    override fun observeViewModel() {
        viewModel.gameList.observe(viewLifecycleOwner, Observer {resultData ->
            if(paginationCounter == 1)
                gameList.clear()
            resultData.toData()?.results?.let { result -> gameList.addAll(result) }
            gameRecyclerAdapter.gameResult = gameList
            gameRecyclerAdapter.notifyDataSetChanged()
        })
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {
        sharedElementEnterTransition = TransitionInflater.from(this.requireContext()).inflateTransition(android.R.transition.move)

        binding.gameListRecyclerView.adapter = gameRecyclerAdapter
        binding.gameListRecyclerView.layoutManager = GridLayoutManager(requireContext(),1)

        gameRecyclerAdapter.setOnItemClickListener {

        }

        binding.searchText.setOnEditorActionListener { textView, actionId, keyEvent ->
            var handled = false
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                lastQuery = binding.searchText.text.toString()
                paginationCounter = 1
                performSearch()
                handled = true
                requireActivity().hideKeyboard()
            }
            handled
        }

        binding.searchIcon.setOnClickListener {
            paginationCounter = 1
            lastQuery = binding.searchText.text.toString()
            performSearch()
        }

        binding.gameListRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    paginationCounter += 1
                    performSearch()
                }
            }
        })
    }

    private fun performSearch(){
        viewModel.getGames(paginationCounter,lastQuery)
    }
}