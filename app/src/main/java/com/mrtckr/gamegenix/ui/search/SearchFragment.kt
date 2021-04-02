package com.mrtckr.gamegenix.ui.search

import android.app.AlertDialog
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrtckr.gamegenix.R
import com.mrtckr.gamegenix.common.BaseFragment
import com.mrtckr.gamegenix.common.hideKeyboard
import com.mrtckr.gamegenix.databinding.FragmentSearchBinding
import com.mrtckr.gamegenix.model.games.GameResult
import com.mrtckr.gamegenix.model.games.SortingType
import com.mrtckr.gamegenix.ui.home.GameRecyclerAdapter
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
    private var lastSortingType = SortingType.Default

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
            }
            handled
        }

        binding.filterIcon.setOnClickListener {
            performFilter()
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

        val callBack = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callBack)
    }

    private fun performFilter() {
        val mDialogView = LayoutInflater.from(this.requireContext()).inflate(
            R.layout.sort_list_popup,
            null
        )

        val mAlertDialog = AlertDialog
            .Builder(this.requireContext())
            .setView(mDialogView).show()

        mAlertDialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val defaultSortingRadioButton = mDialogView.findViewById<RadioButton>(R.id.sortingDefault)
        val sortingByPopularityRadioButton = mDialogView.findViewById<RadioButton>(R.id.sortingPopularity)
        val sortingByRatingRadioButton = mDialogView.findViewById<RadioButton>(R.id.sortingRating)
        val sortingByReleasedRadioButton = mDialogView.findViewById<RadioButton>(R.id.sortingReleased)
        val sortingByUpdatedRadioButton = mDialogView.findViewById<RadioButton>(R.id.sortingUpdated)


        mDialogView.findViewById<RadioGroup>(R.id.radioGroup).setOnCheckedChangeListener { compoundButton, b ->
            when (compoundButton.checkedRadioButtonId) {
                defaultSortingRadioButton.id -> {
                    lastSortingType = SortingType.Default
                }
                sortingByPopularityRadioButton.id -> {
                    lastSortingType = SortingType.Popularity
                }
                sortingByRatingRadioButton.id -> {
                    lastSortingType = SortingType.Rating
                }
                sortingByReleasedRadioButton.id -> {
                    lastSortingType = SortingType.Released
                }
                sortingByUpdatedRadioButton.id -> {
                    lastSortingType = SortingType.Updated
                }
            }
            performSearch()
            mAlertDialog.dismiss()
        }

        mDialogView.findViewById<Button>(R.id.sortingCancel).setOnClickListener {
            mAlertDialog.dismiss()
        }
    }

    private fun performSearch(){
        requireActivity().hideKeyboard()
        viewModel.getGames(paginationCounter,lastQuery,lastSortingType)
    }
}