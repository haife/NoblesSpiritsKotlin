package com.haife.app.nobles.spirits.kotlin.mvp.contract;

import android.support.v4.app.Fragment;

import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.BaseResponse;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.Token;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommendData;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.RestaurantUnionBean;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;

import java.util.List;

import io.reactivex.Observable;

/**
 * @ author haife
 * @ since 2018/12/18
 * TODO：
 */
public interface HomeContract {

    interface View extends IView {
        Fragment getFragment();
        //首页指示器初始化
        void initMagicIndicatorView(List<String> magicIndicatorContentList);

    }

    interface Model extends IModel {
        Observable<BaseResponse<RestaurantUnionBean>> getUnionRestaurant(Token mainBean);
        Observable<BaseResponse<HomeRecommendData>> getHomeRecommendData(Token mainBean);
    }
}
