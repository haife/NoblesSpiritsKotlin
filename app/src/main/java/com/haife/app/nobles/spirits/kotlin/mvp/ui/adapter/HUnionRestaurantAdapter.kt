package com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter

import android.content.Context
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import com.chad.library.adapter.base.BaseViewHolder
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.app.base.BaseQuickRecycleAdapter
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.bean.UnionRestaurantBean
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.bean.getLabels
import com.haife.app.nobles.spirits.kotlin.mvp.ui.widget.restaurant.LineBreakLayout

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/22
 * 联盟餐厅列表适配器
 */
class HUnionRestaurantAdapter(layoutResId: Int, data: List<UnionRestaurantBean>, context: Context) : BaseQuickRecycleAdapter<UnionRestaurantBean>(layoutResId, data, context) {

    override fun convert(helper: BaseViewHolder, item: UnionRestaurantBean) {
        loadImage(helper.getView(R.id.iv_recycle_item_union_bg), R.drawable.ic_flash_sale_product_place_holder, item.string_pic_logo)
        helper.getView<TextView>(R.id.tv_recycle_item_union_average_price).typeface = typeFaceTint
        helper.getView<TextView>(R.id.tv_recycle_item_union_desc).typeface = typeFaceTint
        helper.getView<TextView>(R.id.tv_new_enter_shape).visibility = when (item.bool_is_new) {
            true -> VISIBLE
            false -> GONE
        }
        helper.setText(R.id.tv_recycle_item_union_desc, item.string_slogn).setText(R.id.tv_recycle_item_union_name, item.string_title)
                .setText(R.id.tv_recycle_item_union_average_price, context.getString(R.string.average_price_desc, item.float_money))
        val labelLL: LineBreakLayout = helper.getView(R.id.ll_recycle_item_union_label)
        if (labelLL.childCount != 0) {
            labelLL.removeAllViews()
        }
        if (item.arr_category.isNotEmpty()) {
            labelLL.setLabels(item.arr_category.getLabels())
        }
    }

}

