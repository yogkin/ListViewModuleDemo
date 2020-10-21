package com.fumi.refreshrecyclerview

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

interface IRefreshView<T> {
    fun getAdapterList(): MutableList<T>
    fun getAdapter(): RecyclerView.Adapter<*>
    fun getRefreshData(isRefresh: Boolean, pageParam: PageParam,refreshLayout: RefreshLayout)
    fun getAdapterLayoutManager(): LinearLayoutManager

    /**
     * 是否分页
     */
    fun isPaging() = true
}