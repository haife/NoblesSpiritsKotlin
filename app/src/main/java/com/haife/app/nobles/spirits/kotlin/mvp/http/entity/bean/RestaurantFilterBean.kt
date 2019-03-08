package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.bean

/**
 * 联盟餐厅筛选数据:根据餐厅类型筛选
 */
data class RestaurantFilterBean(
        var int_id: Int,
        val string_title_cn: String,
        val string_title_en: String)



/**
 *  联盟餐厅筛选数据:根据餐厅品牌筛选
 */
data class RestaurantAverageBean(
        val int_spend_id: Int,
        val string_name: String,
        val string_name_en: String
)