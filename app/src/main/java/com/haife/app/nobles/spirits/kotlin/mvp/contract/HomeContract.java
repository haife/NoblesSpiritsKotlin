package com.haife.app.nobles.spirits.kotlin.mvp.contract;


import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.Token;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.request.UnionRestaurantRequest;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommendData;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.RestaurantUnionBean;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import androidx.fragment.app.Fragment;
import io.reactivex.Observable;

/**
 * @ author haife
 * @ since 2018/12/18
 * TODO：
 */
public interface HomeContract {

    interface View extends IView, OnRefreshListener {
        Fragment getFragment();

        //首页指示器初始化
        void initMagicIndicatorView(List<String> magicIndicatorContentList);
        //网络请求状态回调
        void refreshStatusListener(boolean refreshSuccess);
    }

    interface Model extends IModel {
        Observable<RestaurantUnionBean> getUnionRestaurant(UnionRestaurantRequest request);
        Observable<HomeRecommendData> getHomeRecommendData(Token mainBean, boolean isEvictCache);
    }
}
