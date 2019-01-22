package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.bean
/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/22
 * @JvmFiled Kotlin 生成.java文件时属性默认为 private，给属性添加声明可以转成 public
 */
 data class UnionRestaurantBean(
        
        val arr_category: List<ArrCategory>,
        
        val bool_booking_status: Boolean,
        
        val bool_is_new: Boolean,
        
        val bool_is_recommend: Boolean,
        
        val float_money: Int,
        
        val int_shop_id: Int,
        
        val int_sid: Int,
        
        val string_city: String,
        
        val string_city_en: String,
        
        val string_mt_logo: String,
        
        val string_pic_logo: String,
        
        val string_slogn: String,
        
        val string_slogn_en: String,
        
        val string_title: String,
        
        val string_title_en: String
)

public data class ArrCategory(
        
        val string_title: String,
        
        val string_title_en: String
)