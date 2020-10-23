package com.fumi.refreshrecyclerview

import androidx.recyclerview.widget.RecyclerView

interface IRefreshView<T> {
    /**
     * 获取Adapter 集合的列表
     */
    fun getAdapterList(): MutableList<T>

    /**
     * 获取adapter
     */
    fun getAdapter(): RecyclerView.Adapter<*>

    /**
     * 获取刷新的数据
     */
    fun getRefreshData(isRefresh: Boolean, pageParam: PageParam,refreshLayout: RefreshLayout)

    /**
     * 是否分页
     */
    fun isPaging() = true
}