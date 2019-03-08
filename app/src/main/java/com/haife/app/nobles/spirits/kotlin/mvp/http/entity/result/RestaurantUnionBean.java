package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result;

import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.Data;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.bean.CityBean;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.bean.RestaurantAverageBean;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.bean.RestaurantFilterBean;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.bean.UnionRestaurantBean;

import java.util.List;

public class RestaurantUnionBean extends Data<RestaurantUnionBean> {

    public List<CityBean> arr_city;
    /*联盟餐厅口味种类筛选*/
    public List<RestaurantFilterBean> arr_shop_types;
    /*联盟餐厅金额数量*/
    public List<RestaurantAverageBean> arr_average_spend;
    public List<UnionRestaurantBean> arr_search_shop_data;

    public List<CityBean> getArr_city() {
        return arr_city;
    }

    public void setArr_city(List<CityBean> arr_city) {
        this.arr_city = arr_city;
    }

    public List<RestaurantFilterBean> getArr_shop_types() {
        return arr_shop_types;
    }

    public void setArr_shop_types(List<RestaurantFilterBean> arr_shop_types) {
        this.arr_shop_types = arr_shop_types;
    }


    public List<RestaurantAverageBean> getArr_average_spend() {
        return arr_average_spend;
    }

    public void setArr_average_spend(List<RestaurantAverageBean> arr_average_spend) {
        this.arr_average_spend = arr_average_spend;
    }

    public List<UnionRestaurantBean> getArr_search_shop_data() {
        return arr_search_shop_data;
    }

    public void setArr_search_shop_data(List<UnionRestaurantBean> arr_search_shop_data) {
        this.arr_search_shop_data = arr_search_shop_data;
    }



}
