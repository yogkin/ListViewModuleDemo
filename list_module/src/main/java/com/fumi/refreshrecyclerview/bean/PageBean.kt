package com.fumi.refreshrecyclerview.bean

abstract class PageBean {
    var total: Int = 0
    var pages: Int = 0
    abstract fun getPageList(): List<*>
}