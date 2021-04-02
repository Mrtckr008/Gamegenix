package com.mrtckr.gamegenix.ui.genres.adapter

import android.content.Context
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
import com.bumptech.glide.RequestManager
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.*
import javax.inject.Inject

class GenresSectionedAdapter @Inject constructor(
    @ApplicationContext val context: Context,
    private val glide : RequestManager
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mValid = true
    private val mSections = SparseArray<Section?>()
    private var sectionResourceId: Int ?= null
    private var textResourceId: Int ?= null
    lateinit var recyclerView: RecyclerView
    lateinit var baseAdapter: RecyclerView.Adapter<GenresGameRecyclerAdapter.ImageViewHolder>

    class SectionViewHolder(view: View, mTextResourceId: Int) :
        RecyclerView.ViewHolder(view) {
        var title = view.findViewById<View>(mTextResourceId) as TextView
    }

    fun setup(sectionResourceId: Int, textResourceId:Int, recyclerView: RecyclerView, baseAdapter: RecyclerView.Adapter<GenresGameRecyclerAdapter.ImageViewHolder>){
        this.sectionResourceId = sectionResourceId
        this.textResourceId = textResourceId
        this.recyclerView = recyclerView
        this.baseAdapter = baseAdapter

        baseAdapter.registerAdapterDataObserver(object : AdapterDataObserver() {
            override fun onChanged() {
                mValid = baseAdapter.itemCount > 0
                notifyDataSetChanged()
            }

            override fun onItemRangeChanged(
                positionStart: Int,
                itemCount: Int
            ) {
                mValid = baseAdapter.itemCount > 0
                notifyItemRangeChanged(positionStart, itemCount)
            }

            override fun onItemRangeInserted(
                positionStart: Int,
                itemCount: Int
            ) {
                mValid = baseAdapter.itemCount > 0
                notifyItemRangeInserted(positionStart, itemCount)
            }

            override fun onItemRangeRemoved(
                positionStart: Int,
                itemCount: Int
            ) {
                mValid = baseAdapter.itemCount > 0
                notifyItemRangeRemoved(positionStart, itemCount)
            }
        })

        (recyclerView.layoutManager as? GridLayoutManager)?.let {
            it.spanSizeLookup = object : SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (isSectionHeaderPosition(position)) it.spanCount else 1
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        typeView: Int
    ): RecyclerView.ViewHolder {
        return if (typeView == SECTION_TYPE) {
            val view =
                LayoutInflater.from(context).inflate(sectionResourceId!!, parent, false)
            SectionViewHolder(
                view,
                textResourceId!!
            )
        } else {
            baseAdapter.onCreateViewHolder(parent, typeView - 1)
        }
    }

    override fun onBindViewHolder(
        sectionViewHolder: RecyclerView.ViewHolder,
        position: Int
    ) {
        if (isSectionHeaderPosition(position)) {
            (sectionViewHolder as SectionViewHolder).title.text = mSections[position]!!.title
        }
        else{
            baseAdapter.onBindViewHolder(sectionViewHolder as GenresGameRecyclerAdapter.ImageViewHolder,
                sectionedPositionToPosition(position));
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (isSectionHeaderPosition(position)) SECTION_TYPE else baseAdapter.getItemViewType(
            sectionedPositionToPosition(position)
        ) + 1
    }

    class Section(var firstPosition: Int, var title: CharSequence, var iconUrl: String) {
        var sectionedPosition = 0
    }

    fun setSections(sections: List<Section>) {
        mSections.clear()
        Arrays.sort(
            sections.toTypedArray()
        ) { o, o1 -> if (o.firstPosition == o1.firstPosition) 0 else if (o.firstPosition < o1.firstPosition) -1 else 1 }
        var offset = 0 // offset positions for the headers we're adding
        for (section in sections) {
            section.sectionedPosition = section.firstPosition + offset
            mSections.append(section.sectionedPosition, section)
            ++offset
        }
        notifyDataSetChanged()
    }

    fun positionToSectionedPosition(position: Int): Int {
        var offset = 0
        for (i in 0 until mSections.size()) {
            if (mSections.valueAt(i)!!.firstPosition > position) {
                break
            }
            ++offset
        }
        return position + offset
    }

    private fun sectionedPositionToPosition(sectionedPosition: Int): Int {
        if (isSectionHeaderPosition(sectionedPosition)) {
            return RecyclerView.NO_POSITION
        }
        var offset = 0
        for (i in 0 until mSections.size()) {
            if (mSections.valueAt(i)!!.sectionedPosition > sectionedPosition) {
                break
            }
            --offset
        }
        return sectionedPosition + offset
    }

    fun isSectionHeaderPosition(position: Int): Boolean {
        return mSections[position] != null
    }

    override fun getItemId(position: Int): Long {
        return if (isSectionHeaderPosition(position)) (Int.MAX_VALUE - mSections.indexOfKey(
            position
        )).toLong() else baseAdapter.getItemId(sectionedPositionToPosition(position))
    }

    override fun getItemCount(): Int {
        return if (mValid) baseAdapter.itemCount + mSections.size() else 0
    }

    companion object {
        private const val SECTION_TYPE = 0
    }

    init {

    }
}