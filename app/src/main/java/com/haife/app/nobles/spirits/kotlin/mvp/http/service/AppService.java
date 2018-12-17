package com.haife.app.nobles.spirits.kotlin.mvp.http.service;

import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.BaseResponse;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.restaurant.RestaurantUnionBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AppService {
    /**
     * 获取联盟餐厅
     */

    @POST("api.php?s=/shop/index")
    Observable<BaseResponse<RestaurantUnionBean>> getUnionRestaurant(@Body RequestBody requestBody);
}
