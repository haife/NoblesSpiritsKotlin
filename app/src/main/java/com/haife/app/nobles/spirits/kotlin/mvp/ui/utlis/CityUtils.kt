package com.haife.app.nobles.spirits.kotlin.mvp.ui.utlis

import com.blankj.utilcode.util.SPUtils
import com.google.gson.Gson
import com.haife.app.nobles.spirits.kotlin.app.constant.SPConstant
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.bean.CityBean
import javax.inject.Inject

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/29
 * TODO:
 */

class CityUtils {
    @Inject
    lateinit var gson: Gson

    /**
     * sava method
     * @param cityList List<CityBean>
     */
    fun putCityList(cityList: List<CityBean>) {
        if (cityList.isNotEmpty()) {
            SPUtils.getInstance().put(SPConstant.SP_CITY_LIST, gson.toJson(cityList))
        }
    }

    fun getCityId() {

       // val cityList:List<CityBean> =
    }
}