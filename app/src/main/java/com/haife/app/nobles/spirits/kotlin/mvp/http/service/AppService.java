package com.haife.app.nobles.spirits.kotlin.mvp.http.service;


import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.BaseResponse;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommendData;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.RestaurantUnionBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AppService {
    /*
     * 首页推荐
     */
    @POST("api.php?s=/index/app_index")
    Observable<BaseResponse<HomeRecommendData>> getHomeRecommendData(@Body RequestBody requestBody);


    /**
     * 首页联盟餐厅
     */
    @POST("api.php?s=/shop/index")
    Observable<BaseResponse<RestaurantUnionBean>> getHomeUnionRestaurant(@Body RequestBody requestBody);

}
