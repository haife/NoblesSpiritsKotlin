package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommendData

/**
 * @ author haife
 * @ since 2019/1/2
 * TODO：
 */
class HRecommendMultiItemEntity : HomeRecommendData(), MultiItemEntity {

    var TypeItem = -1

    companion object {
        //banner
        const val BANNER_TYPE = 0
        //每周特惠
        const val WEEK_PREFERENTIAL = 1
        //世界名庄
        const val WORLD_FINE_WINE = 2
        //团购活动
        const val GROUP_BUY_ACTIVITY = 3
        //推荐餐厅
        const val RECOMMEND_RESTAURANT = 4
        //品味生活
        const val TASTE_OF_LIFE = 5
        //新入驻餐厅
        const val NEW_RECOMMEND_RESTAURANT = 6
    }

    override fun getItemType(): Int {
        return TypeItem
    }
}