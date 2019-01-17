package com.haife.app.nobles.spirits.kotlin.mvp.ui.decoration

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.haife.app.nobles.spirits.kotlin.R

open class RecycleViewDivide constructor(context: Context, orientation: Int = LinearLayoutManager.VERTICAL, drawableId: Drawable? = null, divideHeight: Int = 40, divideColor: Int = ContextCompat.getColor(context, R.color.home_recycle_view_divide_color)) : RecyclerView.ItemDecoration() {
    private val mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mDivideHeight: Int = divideHeight
    private var mDivideDrawable: Drawable? = null
    private var intOrientation: Int? = null

    init {
        intOrientation = orientation
        mDivideDrawable = drawableId
        mPaint.color = divideColor
        mPaint.style = Paint.Style.FILL
    }
    /**
     * 获取分割线尺寸
     * @param outRect Rect?
     * @param view View?
     * @param parent RecyclerView?
     * @param state RecyclerView.State?
     */
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val childAdapterPosition = parent?.getChildAdapterPosition(view!!)
        val lastCount = parent?.adapter?.itemCount!! - 1
        if (childAdapterPosition == lastCount) {
            outRect?.set(0, 0, 0, 0)
            return
        }
        outRect?.set(0, 0, 0, mDivideHeight)
    }



    /**
     * 绘制分割线
     * @param c Canvas?
     * @param parent RecyclerView?
     * @param state RecyclerView.State?
     */
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c!!, parent!!, state!!)
        when (intOrientation) {
            LinearLayoutManager.VERTICAL -> c?.let { parent?.let { it1 -> drawVertical(it, it1) } }
            LinearLayoutManager.HORIZONTAL -> c?.let { parent?.let { it1 -> drawHorizontal(it, it1) } }
        }

    }

    //绘制纵向 item 分割线
    private fun drawVertical(canvas: Canvas, parent: RecyclerView) {
        val left = parent.paddingLeft
        val right = parent.measuredWidth - parent.paddingRight
        val childSize = parent.childCount
        for (i in 0 until childSize) {
            val child = parent.getChildAt(i)
            val layoutParams = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + layoutParams.bottomMargin
            val bottom = top + mDivideHeight
            mDivideDrawable?.setBounds(left, top, right, bottom)
            mDivideDrawable?.draw(canvas)
            canvas?.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), mPaint)
        }


    }


    //绘制横向 item 分割线
    private fun drawHorizontal(canvas: Canvas, parent: RecyclerView) {

        val top = parent.paddingTop
        val bottom = parent.measuredHeight - parent.paddingBottom
        val childSize = parent.childCount
        for (i in 0 until childSize) {
            val child = parent.getChildAt(i)
            val layoutParams = child.layoutParams as RecyclerView.LayoutParams
            val left = child.right + layoutParams.rightMargin
            val right = left + mDivideHeight

            mDivideDrawable?.setBounds(left, top, right, bottom)
            mDivideDrawable?.draw(canvas)
            canvas?.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), mPaint)
        }
    }
}