package com.mrtckr.gamegenix.ui.genres.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.mrtckr.gamegenix.R
import com.mrtckr.gamegenix.model.genres.GenresGame
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GenresGameRecyclerAdapter @Inject constructor(
    @ApplicationContext val context: Context
) : RecyclerView.Adapter<GenresGameRecyclerAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    private val diffUtil = object : DiffUtil.ItemCallback<GenresGame>() {
        override fun areItemsTheSame(
            oldItem: GenresGame,
            newItem: GenresGame
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: GenresGame,
            newItem: GenresGame
        ): Boolean {
            return oldItem.equals(newItem)
        }

    }

    private val recyclerListDiffer = AsyncListDiffer(this,diffUtil)

    var genreGameResult : List<GenresGame>
        get() = recyclerListDiffer.currentList
        set(value) = recyclerListDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.genre_game_item_list,parent,false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val gameText = holder.itemView.findViewById<TextView>(R.id.genreText)
        val viewTag = holder.itemView.tag
        holder.itemView.apply {
            gameText.text = genreGameResult[position].name
        }
        gameText.setOnClickListener {view->
            val productIdBundle = bundleOf(context.getString(R.string.game_id_bundle_name) to genreGameResult[position].id)
            Navigation.findNavController(view).navigate(
                    R.id.action_navigation_genre_to_detailFragment, productIdBundle
            )
        }
    }

    override fun getItemCount(): Int {
        return genreGameResult.size
    }

}