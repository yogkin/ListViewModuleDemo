package com.fumi.simplerecyclerviewdemo.bean


data class ResultBean(
    val children: List<Any> = listOf(),
    val courseId: Int = 0, // 13
    val id: Int = 0, // 408
    val name: String = "", // 鸿洋
    val order: Int = 0, // 190000
    val parentChapterId: Int = 0, // 407
    val userControlSetTop: Boolean = false, // false
    val visible: Int = 0 // 1
)

data class ResultPageBean(
    val apkLink: String = "",
    val audit: Int = 0, // 1
    val author: String = "",
    val canEdit: Boolean = false, // false
    val chapterId: Int = 0, // 502
    val chapterName: String = "", // 自助
    val collect: Boolean = false, // false
    val courseId: Int = 0, // 13
    val desc: String = "",
    val descMd: String = "",
    val envelopePic: String = "",
    val fresh: Boolean = false, // true
    val id: Int = 0, // 15800
    val link: String = "", // https://juejin.im/post/6885358107996717064
    val niceDate: String = "", // 2小时前
    val niceShareDate: String = "", // 2小时前
    val origin: String = "",
    val prefix: String = "",
    val projectLink: String = "",
    val publishTime: Long = 0, // 1603170873000
    val realSuperChapterId: Int = 0, // 493
    val selfVisible: Int = 0, // 0
    val shareDate: Long = 0, // 1603170873000
    val shareUser: String = "", // Amter
    val superChapterId: Int = 0, // 494
    val superChapterName: String = "", // 广场Tab
    val tags: List<Any> = listOf(),
    val title: String = "", // Android 网络框架之Retrofit源码解析
    val type: Int = 0, // 0
    val userId: Int = 0, // 49976
    val visible: Int = 0, // 1
    val zan: Int = 0 // 0
)