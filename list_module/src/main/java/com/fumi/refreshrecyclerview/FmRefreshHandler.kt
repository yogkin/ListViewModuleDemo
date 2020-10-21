package com.fumi.refreshrecyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.annotation.NonNull
import com.scwang.smart.drawable.ProgressDrawable
import com.scwang.smart.refresh.classics.ArrowDrawable
import com.scwang.smart.refresh.layout.api.RefreshFooter
import com.scwang.smart.refresh.layout.api.RefreshHeader
import com.scwang.smart.refresh.layout.api.RefreshKernel
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.constant.RefreshState
import com.scwang.smart.refresh.layout.constant.SpinnerStyle
import com.scwang.smart.refresh.layout.util.SmartUtil


class RefreshView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null
) :
    LinearLayout(context, attrs, 0), RefreshHeader, RefreshFooter {

    private var mNoMoreData = false

    private val mHeaderText //标题文本
            : TextView
    private val mArrowView //下拉箭头
            : ImageView
    private val mProgressView //刷新动画视图
            : ProgressBar
    private val mProgressDrawable //刷新动画
            : ProgressDrawable

    init {
        gravity = Gravity.CENTER
        mHeaderText = TextView(context)
        mProgressDrawable = ProgressDrawable()
        mArrowView = ImageView(context)
        mProgressView = ProgressBar(context)
        mArrowView.setImageDrawable(ArrowDrawable())
        addView(mProgressView, SmartUtil.dp2px(20f), SmartUtil.dp2px(20f))
        addView(mArrowView, SmartUtil.dp2px(10f), SmartUtil.dp2px(10f))
        addView(Space(context), SmartUtil.dp2px(10f), SmartUtil.dp2px(10f))
        addView(
            mHeaderText,
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
        minimumHeight = SmartUtil.dp2px(35f)
    }

    @NonNull
    override fun getView(): View {
        return this //真实的视图就是自己，不能返回null
    }

    @NonNull
    override fun getSpinnerStyle(): SpinnerStyle {
        return SpinnerStyle.Translate //指定为平移，不能null
    }

    override fun onStartAnimator(
        @NonNull layout: RefreshLayout,
        height: Int,
        maxDragHeight: Int
    ) {
        mProgressDrawable.start() //开始动画
    }


    override fun onFinish(@NonNull layout: RefreshLayout, success: Boolean): Int {
        if (mNoMoreData.not()) {
            mProgressDrawable.stop() //停止动画
            mProgressView.visibility = View.GONE //隐藏动画
            if (success) {
                mHeaderText.text = "刷新完成"
            } else {
                mHeaderText.text = "刷新失败"
            }
        }

        return 0
    }

    override fun onStateChanged(
        @NonNull refreshLayout: RefreshLayout,
        @NonNull oldState: RefreshState,
        @NonNull newState: RefreshState
    ) {

        when {
            mNoMoreData.not() && newState.isHeader -> {
                when (newState) {
                    RefreshState.None, RefreshState.PullDownToRefresh -> {
                        mHeaderText.text = "下拉刷新"
                        mArrowView.visibility = View.VISIBLE //显示下拉箭头
                        mProgressView.visibility = View.GONE //隐藏动画
                        mArrowView.animate()
                            .also { it.duration = 100 }
                            .rotation(0f) //还原箭头方向
                    }
                    RefreshState.Refreshing -> {
                        mHeaderText.text = "刷新中..."
                        mProgressView.visibility = View.VISIBLE //显示加载动画
                        mArrowView.visibility = View.GONE //隐藏箭头
                    }
                    RefreshState.ReleaseToRefresh -> {
                        mHeaderText.text = "释放刷新"
                        mArrowView.animate()
                            .also { it.duration = 100 }
                            .rotation(-180f) //显示箭头改为朝上
                    }
                    else -> {
                        mHeaderText.text = "释放刷新"
                        mArrowView.animate()
                            .also { it.duration = 100 }
                            .rotation(-180f) //显示箭头改为朝上
                    }
                }
            }
            mNoMoreData.not() && newState.isFooter -> {
                mArrowView.visibility = View.GONE
                when (newState) {
                    RefreshState.Refreshing -> {
                        mHeaderText.text = "释放加载..."
                    }
                    RefreshState.LoadReleased -> {
                        mHeaderText.text = "加载中..."
                        mProgressView.visibility = View.VISIBLE //显示加载动画
                    }
                    RefreshState.RefreshFinish -> {
                        mHeaderText.text = "加载中..."
                        mProgressView.visibility = View.GONE //显示加载动画
                    }
                    else -> {
                        mHeaderText.text = "加载中.."
                        mProgressView.visibility = View.VISIBLE //显示加载动画
                    }
                }
            }
        }

    }

    override fun setPrimaryColors(vararg colors: Int) {}
    override fun onInitialized(
        @NonNull kernel: RefreshKernel,
        height: Int,
        maxDragHeight: Int
    ) {
    }

    override fun onMoving(
        isDragging: Boolean,
        percent: Float,
        offset: Int,
        height: Int,
        maxDragHeight: Int
    ) {
    }

    //        @Override
    //        public void onPulling(float percent, int offset, int height, int maxDragHeight) {
    //
    //        }
    //        @Override
    //        public void onReleasing(float percent, int offset, int height, int maxDragHeight) {
    //
    //        }
    override fun onReleased(
        @NonNull refreshLayout: RefreshLayout,
        height: Int,
        maxDragHeight: Int
    ) {
    }

    override fun onHorizontalDrag(
        percentX: Float,
        offsetX: Int,
        offsetMax: Int
    ) {
    }

    override fun setNoMoreData(noMoreData: Boolean): Boolean {
        if (mNoMoreData != noMoreData) {
            mNoMoreData = noMoreData
            if (noMoreData) {
                mHeaderText.text = "没有更多数据啦~"
                mArrowView.visibility = View.GONE

            } else {
                mHeaderText.text = "加载更多"
                mArrowView.visibility = View.VISIBLE
            }
        }
        return true
    }


    override fun isSupportHorizontalDrag(): Boolean {
        return false
    }


}