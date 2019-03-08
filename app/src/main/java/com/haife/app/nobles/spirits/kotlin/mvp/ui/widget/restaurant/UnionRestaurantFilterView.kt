package com.haife.app.nobles.spirits.kotlin.mvp.ui.widget.restaurant

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CompoundButton
import android.widget.LinearLayout
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.bean.RestaurantAverageBean
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.bean.RestaurantFilterBean
import kotlinx.android.synthetic.main.header_union_restaurant_filter.view.*

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/3/8$
 * TODO: 联盟餐厅筛选
 */
class UnionRestaurantFilterView(context: Context, attr: AttributeSet) : LinearLayout(context, attr) {
    private lateinit var cookStyleList: List<RestaurantFilterBean>
    private lateinit var priceList: List<RestaurantAverageBean>
    private val cookCheckBoxTag: String = "TAG_COOK_STYLE_FILTER"
    private val priceCheckBoxTag: String = "TAG_PRICE_STYLE_FILTER"

    constructor(context: Context, attr: AttributeSet, cookStyle: List<RestaurantFilterBean>, priceList: List<RestaurantAverageBean>) : this(context, attr) {
        this.cookStyleList = cookStyle
        this.priceList = priceList
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.header_union_restaurant_filter, this)
        cb_union_cook_style_filter.tag = cookCheckBoxTag
        cb_union_price_filter.tag = priceCheckBoxTag
        clickListener()
    }

    private fun clickListener() {
        cb_union_cook_style_filter.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked: Boolean ->
            disPlayPopWindowFilter(cb_union_cook_style_filter.tag.toString())
        }
    }

    /**
     *
     * @param tag String
     */
    private fun disPlayPopWindowFilter(tag: String) {
        when(tag){

        }
    }

}