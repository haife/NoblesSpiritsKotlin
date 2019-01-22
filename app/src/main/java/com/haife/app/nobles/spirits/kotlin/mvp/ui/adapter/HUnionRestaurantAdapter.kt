package com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter

import android.content.Context
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.bean.UnionRestaurantBean

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/22
 * 联盟餐厅列表适配器
 */
class HUnionRestaurantAdapter(layoutResId: Int, data: List<UnionRestaurantBean>, val context: Context) : BaseQuickAdapter<UnionRestaurantBean, BaseViewHolder>(layoutResId, data) {


    override fun convert(helper: BaseViewHolder, item: UnionRestaurantBean?) {

    }


}

