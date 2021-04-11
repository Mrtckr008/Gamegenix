package com.mrtckr.gamegenix.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.mrtckr.gamegenix.R
import com.mrtckr.gamegenix.common.gone
import com.mrtckr.gamegenix.model.games.GameResult
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import androidx.navigation.fragment.findNavController
import com.mrtckr.gamegenix.databinding.GameItemListBinding
import java.lang.Exception

class GameRecyclerAdapter @Inject constructor(
    private val glide: RequestManager,
    @ApplicationContext val context:  Context
) : RecyclerView.Adapter<GameRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = GameItemListBinding.bind(itemView)
        val gameImage = binding.gameImage
        val gameGenre = binding.genreText
        val gameName = binding.gameNameText
        val gameRating = binding.gameRatingText
    }

    private val diffUtil = object : DiffUtil.ItemCallback<GameResult>() {
        override fun areItemsTheSame(
            oldItem: GameResult,
            newItem: GameResult
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: GameResult,
            newItem: GameResult
        ): Boolean {
            return oldItem.equals(newItem)
        }

    }

    private val recyclerListDiffer = AsyncListDiffer(this, diffUtil)

    var gameResult: List<GameResult>
        get() = recyclerListDiffer.currentList
        set(value) = recyclerListDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.game_item_list, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            glide.load(gameResult[position].backgroundImage).into(holder.gameImage).apply {
                setOnClickListener {
                    val productIdBundle = bundleOf(context.getString(R.string.game_id_bundle_name) to gameResult[position].id)
                    try {
                        findNavController(it).navigate(
                            R.id.action_navigation_home_to_detailFragment, productIdBundle
                        )
                    }
                    catch (e:Exception){
                        findNavController(it).navigate(
                            R.id.action_navigation_search_to_detailFragment, productIdBundle
                        )
                    }

                }
            }

            if (gameResult[position].genres?.isNotEmpty()!!) {
                holder.gameGenre.text = gameResult[position].genres?.get(0)?.name
            } else {
                holder.gameGenre.gone()
            }

            if (gameResult[position].rating != null) {
                holder.gameRating.text = gameResult[position].rating.toString()
            } else {
                holder.gameRating.gone()
            }

            holder.gameName.text = gameResult[position].name
        }
    }

    override fun getItemCount(): Int {
        return gameResult.size
    }

}