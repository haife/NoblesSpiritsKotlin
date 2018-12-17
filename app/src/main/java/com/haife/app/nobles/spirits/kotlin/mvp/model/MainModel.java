package com.haife.app.nobles.spirits.kotlin.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.haife.app.nobles.spirits.kotlin.mvp.contract.MainContract;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.BaseResponse;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.Token;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.restaurant.RestaurantUnionBean;
import com.haife.app.nobles.spirits.kotlin.mvp.http.service.AppService;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import timber.log.Timber;

@ActivityScope
public class MainModel extends BaseModel implements MainContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public MainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }


    @Override
    public Observable<BaseResponse<RestaurantUnionBean>> getUnionRestaurant(Token bean) {
        Timber.e("PostJson: " +mGson.toJson(bean));
        return mRepositoryManager.obtainRetrofitService(AppService.class).getUnionRestaurant(getRequestBody(mGson.toJson(bean)));
    }

    public RequestBody getRequestBody(String postJson) {
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), postJson);
        return body;
    }
}
