package com.fumi.simplerecyclerviewdemo.bean

import com.fumi.refreshrecyclerview.bean.PageBean

data class ListResponse(
    val curPage: Int = 0, // 4
    val datas: List<Data> = listOf(),
    val offset: Int = 0, // 60
    val over: Boolean = false, // false
    val pageCount: Int = 0, // 469
    val size: Int = 0 // 20
): PageBean() {
    override fun getPageList() = datas

}

data class Data(
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
    val fresh: Boolean = false, // false
    val id: Int = 0, // 15691
    val link: String = "", // https://juejin.im/post/6882370280946302983
    val niceDate: String = "", // 2020-10-12 10:12
    val niceShareDate: String = "", // 2020-10-12 10:12
    val origin: String = "",
    val prefix: String = "",
    val projectLink: String = "",
    val publishTime: Long = 0, // 1602468756000
    val realSuperChapterId: Int = 0, // 493
    val selfVisible: Int = 0, // 0
    val shareDate: Long = 0, // 1602468756000
    val shareUser: String = "", // 彭旭锐
    val superChapterId: Int = 0, // 494
    val superChapterName: String = "", // 广场Tab
    val tags: List<Tag> = listOf(),
    val title: String = "", // 算法面试题 | 链表问题总结
    val type: Int = 0, // 0
    val userId: Int = 0, // 30587
    val visible: Int = 0, // 1
    val zan: Int = 0 // 0
)

data class Data2(
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
    val fresh: Boolean = false, // false
    val id: Int = 0, // 15691
    val link: String = "", // https://juejin.im/post/6882370280946302983
    val niceDate: String = "", // 2020-10-12 10:12
    val niceShareDate: String = "", // 2020-10-12 10:12
    val origin: String = "",
    val prefix: String = "",
    val projectLink: String = "",
    val publishTime: Long = 0, // 1602468756000
    val realSuperChapterId: Int = 0, // 493
    val selfVisible: Int = 0, // 0
    val shareDate: Long = 0, // 1602468756000
    val shareUser: String = "", // 彭旭锐
    val superChapterId: Int = 0, // 494
    val superChapterName: String = "", // 广场Tab
    val tags: List<Tag> = listOf(),
    val title: String = "", // 算法面试题 | 链表问题总结
    val type: Int = 0, // 0
    val userId: Int = 0, // 30587
    val visible: Int = 0, // 1
    val zan: Int = 0 // 0
)

data class Tag(
    val name: String = "", // 本站发布
    val url: String = "" // /article/list/0?cid=440
)