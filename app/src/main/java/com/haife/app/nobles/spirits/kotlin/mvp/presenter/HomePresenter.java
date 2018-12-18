package com.haife.app.nobles.spirits.kotlin.mvp.presenter;

import android.app.Application;

import com.haife.app.nobles.spirits.kotlin.mvp.contract.HomeContract;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.BaseResponse;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.Token;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommandData;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.RestaurantUnionBean;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.RxLifecycleUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;


@FragmentScope
public class HomePresenter extends BasePresenter<HomeContract.Model, HomeContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;
    @Inject
    RestaurantUnionBean mRestaurantUnionBean;
    @Inject
    HomeRecommandData mHomeRecommandData;

    @Inject
    public HomePresenter(HomeContract.Model model, HomeContract.View rootView) {
        super(model, rootView);
    }

    /**
     * 首页联盟餐厅
     *
     * @param token
     */
    public void getHomeUnionRestaurant(Token token) {
        mModel.getUnionRestaurant(token).compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retryWhen(new RetryWithDelay(3, 2))//遇到错误时重试, 第一个参数为重试几次, 第二个参数为重试的间隔, 单位为秒
                .subscribe(new ErrorHandleSubscriber<BaseResponse<RestaurantUnionBean>>(mErrorHandler) {
                    @Override
                    public void onNext(BaseResponse<RestaurantUnionBean> response) {
                        if (response.getData().isSuccess())
                            mRestaurantUnionBean = response.getData().getResult();
                        else
                            mRootView.showMessage(response.getData().getMsg());
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);

                    }
                });


    }

    /**
     * 首页推荐
     *
     * @param token
     */
    public void getHomeRecommandData(Token token) {
        mModel.getHomeRecommandData(token).compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retryWhen(new RetryWithDelay(3, 2))
                .subscribe(new ErrorHandleSubscriber<BaseResponse<HomeRecommandData>>(mErrorHandler) {
                    @Override
                    public void onNext(BaseResponse<HomeRecommandData> response) {
                        if (response.getData().isSuccess())
                            mHomeRecommandData = response.getData().getResult();
                        else
                            mRootView.showMessage(response.getData().getMsg());
                    }
                });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }
}
