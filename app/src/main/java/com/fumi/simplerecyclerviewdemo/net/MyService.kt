package com.fumi.simplerecyclerviewdemo.net

import com.fumi.net_module.bean.BaseHttpBean
import com.fumi.simplerecyclerviewdemo.bean.ListResponse
import com.fumi.simplerecyclerviewdemo.bean.ResultBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface MyService {
    /**
     * 获取列表
     */

    @GET("/app/customer/list")
    fun getCustomerList(@QueryMap map: Map<String, String>): Flowable<BaseHttpBean<ListResponse>>

    /**
     * 获取列表
     */

    @GET("/wxarticle/chapters/json")
    fun getRoomLiveList(@QueryMap map: Map<String, String>): Flowable<BaseHttpBean<List<ResultBean>>>

    /**
     * 文章列表
     */

    @GET("/article/list/{page}/json")
    fun getArtList(@Path("page") page: String): Flowable<BaseHttpBean<ListResponse>>
}