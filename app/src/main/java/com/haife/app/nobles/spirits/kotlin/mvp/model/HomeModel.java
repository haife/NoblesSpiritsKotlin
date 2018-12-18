package com.haife.app.nobles.spirits.kotlin.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.haife.app.nobles.spirits.kotlin.mvp.contract.HomeContract;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.BaseResponse;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.Token;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommandData;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.RestaurantUnionBean;
import com.haife.app.nobles.spirits.kotlin.mvp.http.service.AppService;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.RequestBody;

/**
 * @ author haife
 * @ since 2018/12/18
 * TODO：
 */
@FragmentScope
public class HomeModel extends BaseModel implements HomeContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public HomeModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }


    @Override
    public Observable<BaseResponse<RestaurantUnionBean>> getUnionRestaurant(Token bean) {
        return mRepositoryManager.obtainRetrofitService(AppService.class).getHomeUnionRestaurant(getRequestBody(mGson.toJson(bean)));
    }

    @Override
    public Observable<BaseResponse<HomeRecommandData>> getHomeRecommandData(Token bean) {
        return mRepositoryManager.obtainRetrofitService(AppService.class).getHomeRecommandData(getRequestBody(mGson.toJson(bean)));
    }

    public RequestBody getRequestBody(String postJson) {
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), postJson);
        return body;
    }
}
