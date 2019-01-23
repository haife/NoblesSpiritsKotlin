package com.haife.app.nobles.spirits.kotlin.mvp.ui.widget

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.haife.app.nobles.spirits.kotlin.R


/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/22
 * 联盟餐厅标签layout
 */
class LineBreakLayout(context: Context, attr: AttributeSet) : ViewGroup(context, attr) {

    //自定义属性
    private var horizontalSpace: Int = 10
    private var verticalSpace: Int = 10
    private var tableList: List<String> = ArrayList()
    private val typeFaceTint = Typeface.createFromAsset(context.assets, "PingFangSC-Light-Face-Medium-Tint.ttf")

    init {
        val ta: TypedArray = context.obtainStyledAttributes(attr, R.styleable.LineBreakLayout)
        horizontalSpace = ta.getDimensionPixelSize(R.styleable.LineBreakLayout_HorizontalSpace, horizontalSpace)
        verticalSpace = ta.getDimensionPixelSize(R.styleable.LineBreakLayout_VerticalSpace, verticalSpace)
        ta.recycle()
    }


    /**el
     * 设置标签
     * @param labels List<String>
     */
    fun setLabels(labels: List<String>) {
        this.tableList = labels
        if (labels.isNotEmpty()) {
            for (element: String in tableList) {
                val tv: TextView = LayoutInflater.from(context).inflate(com.haife.app.nobles.spirits.kotlin.R.layout.item_union_restaurant_label, null) as TextView
                tv.text = element
                tv.typeface = typeFaceTint
                addView(tv)
            }


        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var row = 0
        var right = 0
        var bottom: Int
        for (element: Int in 0 until childCount) {
            val childView: View = getChildAt(element)
            val childW = childView.measuredWidth
            val childH = childView.measuredHeight
            right += childW
            //底部位置=已经摆放的行数*（标签高度+行距）+当前标签高度
            bottom = row * (childH + verticalSpace) + childH
            // 如果右侧位置已经超出布局右边缘，跳到下一行
            // if it can't drawing on a same line , skip to next line
            if (right > (r - horizontalSpace)) {
                row++
                right = childW
                bottom = row * (childH + verticalSpace) + childH
            }
            childView.layout(right - childW, bottom - childH, right, bottom)
            right += horizontalSpace
        }
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //为所有的标签childView计算宽和高
        measureChildren(widthMeasureSpec, heightMeasureSpec)
        //获取高的模式
        val heightMode = View.MeasureSpec.getMode(heightMeasureSpec)
        //建议的高度
        val heightSize = View.MeasureSpec.getSize(heightMeasureSpec)
        //布局的宽度采用建议宽度（match_parent或者size），如果设置wrap_content也是match_parent的效果
        val width = View.MeasureSpec.getSize(widthMeasureSpec)

        val height: Int
        if (heightMode == View.MeasureSpec.EXACTLY) {
            //如果高度模式为EXACTLY（match_perent或者size），则使用建议高度
            height = heightSize
        } else {
            //其他情况下（AT_MOST、UNSPECIFIED）需要计算计算高度
            val childCount = childCount
            if (childCount <= 0) {
                height = 0   //没有标签时，高度为0
            } else {
                var row = 1  // 标签行数
                var widthSpace = width// 当前行右侧剩余的宽度
                for (i in 0 until childCount) {
                    val view = getChildAt(i)
                    //获取标签宽度
                    val childW = view.measuredWidth
                    if (widthSpace >= childW) {
                        //如果剩余的宽度大于此标签的宽度，那就将此标签放到本行
                        widthSpace -= childW
                    } else {
                        row++    //增加一行
                        //如果剩余的宽度不能摆放此标签，那就将此标签放入一行
                        widthSpace = width - childW
                    }
                    //减去标签左右间距
                    widthSpace -= horizontalSpace
                }
                //由于每个标签的高度是相同的，所以直接获取第一个标签的高度即可
                val childH = getChildAt(0).measuredHeight
                //最终布局的高度=标签高度*行数+行距*(行数-1)
                height = childH * row + verticalSpace * (row - 1)

            }
        }

        //设置测量宽度和测量高度
        setMeasuredDimension(width, height)
    }
}