package com.fumi.simplerecyclerviewdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fumi.net_module.ApiFactory
import com.fumi.net_module.create
import com.fumi.net_module.view.INetView
import com.fumi.refreshrecyclerview.IRefreshView
import com.fumi.refreshrecyclerview.PageParam
import com.fumi.refreshrecyclerview.RefreshLayout
import com.fumi.refreshrecyclerview.bean.PageBean
import com.fumi.simplerecyclerviewdemo.adapter.FmAdapter
import com.fumi.simplerecyclerviewdemo.net.MyService
import io.reactivex.Flowable
import io.reactivex.disposables.Disposable


val myService = ApiFactory.create<MyService>("https://www.wanandroid.com", debug = true)

abstract class BaseActivity<T> : AppCompatActivity(), INetView, IRefreshView<T> {

    abstract val layoutIds: Int
    abstract val adapter: FmAdapter<T>
    abstract fun getPageFlowAble(pageParam: PageParam): Flowable<out PageBean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutIds)
    }


    override fun getAdapter(): RecyclerView.Adapter<*> = adapter
    override fun getAdapterList() = adapter.mData
    override fun getRefreshData(isRefresh: Boolean, pageParam: PageParam, refreshLayout: RefreshLayout) {
        getPageFlowAble(pageParam).executeNoHandle {
            refreshLayout.putData(isRefresh, it)
        }
    }

    override fun addDisposable(subscription: Disposable) {

    }

    override fun dismissLoading() {

    }

    override fun dispose() {

    }

    override fun showLoading() {

    }

    override fun toast(content: String) {

    }

}