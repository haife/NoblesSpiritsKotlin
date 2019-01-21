package com.haife.app.nobles.spirits.kotlin.mvp.http.api.cache;


import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommendData;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/17$
 * TODO:展示 {@linkRxCache#using(Class)} 中需要传入的 Providers 的使用方式
 */
public interface CommonCache {
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<Reply<HomeRecommendData>> getHomeRecommendDataCache(Observable<HomeRecommendData> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);
}
