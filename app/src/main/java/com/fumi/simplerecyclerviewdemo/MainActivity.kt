package com.fumi.simplerecyclerviewdemo

import android.os.Bundle
import android.view.View
import com.fumi.net_module.asyncAndHandle
import com.fumi.refreshrecyclerview.PageParam
import com.fumi.refreshrecyclerview.bean.PageBean
import com.fumi.refreshrecyclerview.head.DeliveryHeader
import com.fumi.simplerecyclerviewdemo.adapter.FmAdapter
import com.fumi.simplerecyclerviewdemo.bean.Data
import com.fumi.simplerecyclerviewdemo.bean.ListResponse
import com.fumi.simplerecyclerviewdemo.bean.ResultPageBean
import io.reactivex.Flowable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_simple.view.*

class MainActivity : BaseActivity<Data>() {
    override val layoutIds = R.layout.activity_main

    override val adapter: FmAdapter<Data> = object : FmAdapter<Data>(R.layout.item_simple) {
        override fun View.onBindData(holder: Holder, data: Data, position: Int) {
            textView.text = data.title
        }

    }

    override fun getPageFlowAble(pageParam: PageParam): Flowable<out PageBean> {
        return myService.getArtList(pageParam.pageIndex.toString()).asyncAndHandle()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        refreshLayout.setAdapterAndLoad(this, DeliveryHeader(this))
    }


}