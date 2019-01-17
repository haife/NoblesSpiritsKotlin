package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HRecommendBannerBean
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommendData

/**
 * @ author haife
 * @ since 2019/1/2
 * TODO：
 */
class HRecommendMultiItemEntity(private val typeItemStr: String) : HomeRecommendData.ArrModuleDataBean(), MultiItemEntity {

    var bannerData: List<HRecommendBannerBean> = arrayListOf()

    companion object {
        //banner
        const val BANNER_TYPE = 0
        const val STRING_BANNER_TYPE = "banner_type"
        //每周特惠
        const val WEEK_PREFERENTIAL = 1
        const val STRING_WEEK_PREFERENTIAL = "string_weekly_specials_list"

        //团购活动
        const val GROUP_BUY_ACTIVITY = 3
        const val STRING_GROUP_BUY_ACTIVITY = "string_groupon"
        //推荐餐厅
        const val RECOMMEND_RESTAURANT = 4
        const val STRING_RECOMMEND_RESTAURANT = "string_shop_combo"
        //品味生活
        const val TASTE_OF_LIFE = 5
        const val STRING_TASTE_OF_LIFE = "string_latest_news"
        //新入驻餐厅
        const val NEW_RECOMMEND_RESTAURANT = 6
        const val STRING_NEW_RECOMMEND_RESTAURANT = "string_shop_new_list"
        //限时秒杀
        const val FLASH_SAlE = 7
        const val STRING_FLASH_SALE = "string_flash_sale"
        //没有定义的type
        const val NUll_TYPE = -1
    }


    override fun getItemType(): Int = when (typeItemStr) {
        STRING_BANNER_TYPE -> BANNER_TYPE
        STRING_WEEK_PREFERENTIAL -> WEEK_PREFERENTIAL
        STRING_GROUP_BUY_ACTIVITY -> GROUP_BUY_ACTIVITY
        STRING_RECOMMEND_RESTAURANT -> RECOMMEND_RESTAURANT
        STRING_TASTE_OF_LIFE -> TASTE_OF_LIFE
        STRING_NEW_RECOMMEND_RESTAURANT -> NEW_RECOMMEND_RESTAURANT
        STRING_FLASH_SALE -> FLASH_SAlE
        else -> {
            NUll_TYPE
        }
    }

//    fun getItemDataEntity(position: Int): ArrDataBean? {
//        for (i in this.arr_data.indices) {
//            if (this.arr_title_data.sting_module_name == typeItemStr) {
//                return arr_data[position]
//            }
//        }
//        return null
//    }


}