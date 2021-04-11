package com.mrtckr.gamegenix.ui.detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.mrtckr.gamegenix.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import com.mrtckr.gamegenix.databinding.GamePlatformItemListBinding
import com.mrtckr.gamegenix.databinding.GamePlatformStoreOptionalItemListBinding
import com.mrtckr.gamegenix.model.gamedetail.ParentPlatform
import com.mrtckr.gamegenix.model.gamedetail.Platform
import com.mrtckr.gamegenix.model.gamedetail.Platform__2
import com.mrtckr.gamegenix.model.gamedetail.Platform__3

class GamePlatformsAdapter @Inject constructor(
    @ApplicationContext val context:  Context
) : RecyclerView.Adapter<GamePlatformsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = GamePlatformStoreOptionalItemListBinding.bind(itemView)
        val platformName = binding.platformText
    }

    private val diffUtil = object : DiffUtil.ItemCallback<Platform__2>() {
        override fun areItemsTheSame(
            oldItem: Platform__2,
            newItem: Platform__2
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Platform__2,
            newItem: Platform__2
        ): Boolean {
            return oldItem.equals(newItem)
        }

    }

    private val recyclerListDiffer = AsyncListDiffer(this, diffUtil)

    var platformList: List<Platform__2>
        get() = recyclerListDiffer.currentList
        set(value) = recyclerListDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.game_platform_store_optional_item_list, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            holder.platformName.text = platformList[position].platform?.name ?: ""
        }
    }

    override fun getItemCount(): Int {
        return platformList.size
    }

}