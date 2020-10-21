package com.fumi.refreshrecyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.fumi.refreshrecyclerview.bean.PageBean
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.api.RefreshFooter
import com.scwang.smart.refresh.layout.api.RefreshHeader

class RefreshLayout : SmartRefreshLayout {
    constructor(context: Context) : super(context) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context)
    }

    /**
     * 分页的参数
     */
    private val pageParam by lazy { PageParam() }

    private lateinit var iRefreshView: IRefreshView<*>


    fun <T> setAdapter(refreshView: IRefreshView<T>, refreshHeadView: RefreshHeader = RefreshView(context), loadMoreView: RefreshFooter = RefreshView(context)) {
        this.iRefreshView = refreshView
        recyclerView.adapter = iRefreshView.getAdapter()
        recyclerView.layoutManager = iRefreshView.getAdapterLayoutManager()

        setRefreshHeader(refreshHeadView)
        setRefreshFooter(loadMoreView)

        setOnRefreshListener {
            pageParam.pageIndex = 1
            iRefreshView.getRefreshData(true, pageParam, this)
        }
        setOnLoadMoreListener {
            pageParam.pageIndex = ++pageParam.pageIndex
            iRefreshView.getRefreshData(false, pageParam, this)
        }

        setEnableLoadMore(refreshView.isPaging())

        autoRefresh()
    }


    private lateinit var recyclerView: RecyclerView
    var emptyView = View.inflate(context, R.layout.view_list_empty, null)
            .also { it.visibility = View.GONE }


    private fun initView(context: Context) {

        val frameLayout = FrameLayout(context)

        recyclerView = RecyclerView(context)
        recyclerView.overScrollMode = View.OVER_SCROLL_NEVER
        frameLayout.addView(recyclerView, MATCH_PARENT, MATCH_PARENT)
        frameLayout.addView(emptyView, MATCH_PARENT, MATCH_PARENT)
        addView(frameLayout, MATCH_PARENT, MATCH_PARENT)

        setDragRate(1f)
        setHeaderHeight(35f)
        setEnableLoadMore(true)
        setEnableScrollContentWhenLoaded(true)
        setEnableFooterFollowWhenNoMoreData(true)
    }


    private fun <T> addData(addData: MutableList<T>) {
        val data = iRefreshView.getAdapterList() as MutableList<T>
        data.addAll(addData)
        recyclerView.adapter?.notifyDataSetChanged()
        if (addData.isEmpty()) {
            finishLoadMoreWithNoMoreData()
        } else {
            emptyView.visibility = View.GONE
            finishLoadMore()
        }
    }

    private fun <T> setData(adapterData: MutableList<T>) {
        val data = iRefreshView.getAdapterList() as MutableList<T>
        data.clear()
        if (adapterData.isEmpty()) {
            emptyView.visibility = View.VISIBLE
        } else {
            emptyView.visibility = View.GONE
            data.addAll(adapterData)
        }
        recyclerView.adapter?.notifyDataSetChanged()
        finishRefresh()
    }

    fun putData(isRefresh: Boolean, listData: PageBean) {
        if (isRefresh) {
            setData(listData.getPageList().toMutableList())
        } else {
            addData(listData.getPageList().toMutableList())
        }
    }
}