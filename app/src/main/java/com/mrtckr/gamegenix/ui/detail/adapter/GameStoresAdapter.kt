package com.mrtckr.gamegenix.ui.detail.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mrtckr.gamegenix.R
import com.mrtckr.gamegenix.databinding.GamePlatformStoreOptionalItemListBinding
import com.mrtckr.gamegenix.model.gamedetail.Store
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class GameStoresAdapter @Inject constructor(
    @ApplicationContext val context:  Context
) : RecyclerView.Adapter<GameStoresAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = GamePlatformStoreOptionalItemListBinding.bind(itemView)
        val storeName = binding.platformText
    }

    private val diffUtil = object : DiffUtil.ItemCallback<Store>() {
        override fun areItemsTheSame(
            oldItem: Store,
            newItem: Store
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Store,
            newItem: Store
        ): Boolean {
            return oldItem.equals(newItem)
        }

    }

    private val recyclerListDiffer = AsyncListDiffer(this, diffUtil)

    var storeResult: List<Store>
        get() = recyclerListDiffer.currentList
        set(value) = recyclerListDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.game_platform_store_optional_item_list, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            holder.storeName.text = storeResult[position].store?.name
            setOnClickListener {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(storeResult[position].url))
                context.startActivity(browserIntent)
            }
        }
    }

    override fun getItemCount(): Int {
        return storeResult.size
    }

}