package com.fumi.simplerecyclerviewdemo.adapter

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.fumi.refreshrecyclerview.IRefreshView
import com.scwang.smart.refresh.layout.api.RefreshLayout


abstract class FmAdapter<T>(@LayoutRes private val layoutId: Int) :
    RecyclerView.Adapter<FmAdapter.Holder>() {

    var mData = mutableListOf<T>()

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView = View.inflate(parent.context, layoutId, null)
        return Holder(itemView)
    }

    override fun getItemCount() = mData.count()

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.onBindData(holder, mData[position] as T, position)
    }

    abstract fun View.onBindData(holder: Holder, data: T, position: Int)

}

