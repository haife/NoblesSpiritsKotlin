package com.haife.app.nobles.spirits.kotlin.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.haife.app.nobles.spirits.kotlin.mvp.contract.HomeContract;
import com.haife.app.nobles.spirits.kotlin.mvp.http.api.cache.CommonCache;
import com.haife.app.nobles.spirits.kotlin.mvp.http.api.service.AppService;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.BaseRequest;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.Token;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.request.CityIdRequest;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommendData;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.RestaurantUnionBean;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.Reply;
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
    public final String homeDynamicKey = "HomeData";
    public final String unionRestaurant = "unionRestaurant";
    private BaseRequest<CityIdRequest> request = new BaseRequest<>();

    @Inject
    public HomeModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    /**
     * 联盟餐厅
     *
     * @param bean
     * @return
     */
    @Override
    public Observable<RestaurantUnionBean> getUnionRestaurant(CityIdRequest bean) {
        request.setParam(bean);
        return Observable.just(mRepositoryManager.obtainRetrofitService(AppService.class).getHomeUnionRestaurant(getRequestBody(mGson.toJson(request))))
                .flatMap((Function<Observable<RestaurantUnionBean>, ObservableSource<RestaurantUnionBean>>) restaurantUnionBeanObservable -> mRepositoryManager.obtainCacheService(CommonCache.class)
                        .getHomeUnionRestaurantCache(restaurantUnionBeanObservable,
                                new DynamicKey(unionRestaurant),
                                new EvictProvider(false)).map(Reply::getData));
    }


    /**
     * 首页推荐
     *
     * @param bean
     * @param isEvictCache 是否删除缓存,true为
     * @return
     */
    @Override
    public Observable<HomeRecommendData> getHomeRecommendData(Token bean, boolean isEvictCache) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(AppService.class).getHomeRecommendData(getRequestBody(mGson.toJson(bean))))
                .flatMap((Function<Observable<HomeRecommendData>, ObservableSource<HomeRecommendData>>) baseResponseObservable -> mRepositoryManager.obtainCacheService(CommonCache.class)
                        .getHomeRecommendDataCache(baseResponseObservable
                                , new DynamicKey(homeDynamicKey)
                                , new EvictProvider(isEvictCache)).map(Reply::getData));
    }

    private RequestBody getRequestBody(String postJson) {
        return RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), postJson);
    }


}
