package com.mrtckr.gamegenix.ui.genres.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.mrtckr.gamegenix.R
import com.mrtckr.gamegenix.model.genres.GenresGame
import javax.inject.Inject

class GenresGameRecyclerAdapter @Inject constructor(
    private val glide : RequestManager
) : RecyclerView.Adapter<GenresGameRecyclerAdapter.ImageViewHolder>() {

    private var onItemClickListener : ((id: String,imageView: View, transitionName: String) -> Unit)? = null

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


    fun setOnItemClickListener(listener : (id: String,imageView: View, transitionName: String) -> Unit) {
        onItemClickListener = listener
    }


    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val gameText = holder.itemView.findViewById<TextView>(R.id.genreText)
        val viewTag = holder.itemView.tag
        holder.itemView.apply {
            gameText.text = genreGameResult[position].name
        }
        gameText.setOnClickListener {view->
            onItemClickListener?.let {
                genreGameResult[position].id?.let { it1 -> it(it.toString(),view,viewTag.toString()) }
            }
        }
    }

    override fun getItemCount(): Int {
        return genreGameResult.size
    }

}