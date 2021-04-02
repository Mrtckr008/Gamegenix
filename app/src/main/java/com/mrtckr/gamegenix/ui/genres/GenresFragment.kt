package com.mrtckr.gamegenix.ui.genres

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.mrtckr.gamegenix.R
import com.mrtckr.gamegenix.common.BaseFragment
import com.mrtckr.gamegenix.databinding.FragmentGenresBinding
import com.mrtckr.gamegenix.model.genres.GenresDetail
import com.mrtckr.gamegenix.model.genres.GenresGame
import com.mrtckr.gamegenix.ui.genres.adapter.GenresGameRecyclerAdapter
import com.mrtckr.gamegenix.ui.genres.adapter.GenresSectionedAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class GenresFragment @Inject constructor(
    private val gameRecyclerAdapter: GenresGameRecyclerAdapter,
    private val gameSectionedAdapter: GenresSectionedAdapter
) : BaseFragment<GenresViewModel, FragmentGenresBinding>() {

    override val layoutRes: Int = R.layout.fragment_genres
    override val viewModel: GenresViewModel by viewModels()
    private var genresList: ArrayList<GenresGame> = arrayListOf()
    private var genresNameList: ArrayList<String> = arrayListOf()
    override fun observeViewModel() {
        viewModel.genresList.observe(viewLifecycleOwner, Observer { resultData ->
            resultData.toData()?.results?.forEach {
                genresNameList.add(it.name.toString())
            }
            resultData.toData()?.results?.forEach {
                genresList.addAll(it.games!!)
            }
            resultData.toData()?.let { setSectionAdapter(it,genresNameList, genresList) }
        })
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getGenres()

        binding.genreSectionRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 1)
            adapter = gameRecyclerAdapter
        }

        gameRecyclerAdapter.setOnItemClickListener { id, imageView, transitionName ->

        }
    }

    private fun setSectionAdapter(genresDetail: GenresDetail, list: List<String>, gameList: List<GenresGame>) {
        val sections: ArrayList<GenresSectionedAdapter.Section> = arrayListOf()
        val items: ArrayList<String> = arrayListOf()

        val mSectionedAdapter = gameSectionedAdapter

        gameSectionedAdapter.setup(
            R.layout.genre_game_section_item_list,
            R.id.genreText,
            binding.genreSectionRecyclerView,
            gameRecyclerAdapter
        )

        var offset = 0
        list.onEachIndexed { index, entry ->
            sections.add(GenresSectionedAdapter.Section(offset, entry.toUpperCase(Locale.ROOT),
                genresDetail.results?.get(index)?.imageBackground.toString()))
            items.add(entry)
            offset += 6
        }
        mSectionedAdapter.setSections(sections)
        gameRecyclerAdapter.genreGameResult = gameList
        binding.genreSectionRecyclerView.adapter = mSectionedAdapter
        mSectionedAdapter.notifyDataSetChanged()
        gameRecyclerAdapter.notifyDataSetChanged()
    }
}