package com.mrtckr.gamegenix.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.mrtckr.gamegenix.R
import com.mrtckr.gamegenix.common.gone
import com.mrtckr.gamegenix.model.games.GameResult
import javax.inject.Inject

class GameRecyclerAdapter @Inject constructor(
    private val glide : RequestManager
) : RecyclerView.Adapter<GameRecyclerAdapter.ImageViewHolder>() {

    private var onItemClickListener : ((String) -> Unit)? = null

    class ImageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

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

    private val recyclerListDiffer = AsyncListDiffer(this,diffUtil)

    var gameResult : List<GameResult>
        get() = recyclerListDiffer.currentList
        set(value) = recyclerListDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.game_item_list,parent,false)
        return ImageViewHolder(view)
    }


    fun setOnItemClickListener(listener : (String) -> Unit) {
        onItemClickListener = listener
    }


    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val gameImage = holder.itemView.findViewById<ImageView>(R.id.gameImage)
        val gameName = holder.itemView.findViewById<TextView>(R.id.gameNameText)
        val gameGenre = holder.itemView.findViewById<TextView>(R.id.genreText)
        val gameRating = holder.itemView.findViewById<TextView>(R.id.gameRatingText)

        holder.itemView.apply {
            glide.load(gameResult[position].backgroundImage).into(gameImage)
            setOnClickListener {
                onItemClickListener?.let {
                    gameResult[position].backgroundImage?.let { it1 -> it(it1) }
                }
            }
            if(gameResult[position].genres?.isNotEmpty()!!){
                gameGenre.text = gameResult[position].genres?.get(0)?.name
            }
            else{
                gameGenre.gone()
            }

            if(gameResult[position].rating != null){
                gameRating.text = gameResult[position].rating.toString()
            }
            else{
                gameRating.gone()
            }

            gameName.text = gameResult[position].name
        }
    }

    override fun getItemCount(): Int {
        return gameResult.size
    }

}