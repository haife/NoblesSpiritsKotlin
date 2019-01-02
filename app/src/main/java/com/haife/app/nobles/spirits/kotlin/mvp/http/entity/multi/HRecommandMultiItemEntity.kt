package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommandData

/**
 * @ author haife
 * @ since 2019/1/2
 * TODO：
 */
class HRecommandMultiItemEntity : HomeRecommandData(), MultiItemEntity {

    var item_Type = -1

    companion object {
        //banner
        val BANNER_TYPE = 0
        //每周特惠
        val WEEK_PREFERENTIAL = 1
        //世界名庄
        val WORLD_FINE_WINE = 2
        //团购活动
        val GROUP_BUY_ACTIVITY = 3
        //推荐餐厅
        val RECOMMAND_RESTAURANT = 4
        //品味生活
        val TASTE_OF_LIFE = 5
        //新入驻餐厅
        val NEW_RECOMMAND_RESTAURANT = 6
    }

    override fun getItemType(): Int {
        return item_Type
    }
}