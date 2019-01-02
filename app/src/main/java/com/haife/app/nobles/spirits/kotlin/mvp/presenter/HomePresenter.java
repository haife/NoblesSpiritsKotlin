package com.haife.app.nobles.spirits.kotlin.mvp.presenter;

import android.app.Application;

import com.haife.app.nobles.spirits.kotlin.mvp.contract.HomeContract;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.BaseResponse;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.Token;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi.HRecommandMultiItemEntity;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommandData;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.RestaurantUnionBean;
import com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter.HRecommandAdapter;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.RxLifecycleUtils;

import java.util.ArrayList;
import java.util.List;

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
    List<HRecommandMultiItemEntity> hRecommandMultiItemList;
    @Inject
    HRecommandAdapter mRecommandAdapter;

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
                .retryWhen(new RetryWithDelay(3, 2))
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
                        if (response.getData().isSuccess()) {
                            mHomeRecommandData = response.getData().getResult();
                            processRecommandData(mHomeRecommandData);
                        } else {
                            mRootView.showMessage(response.getData().getMsg());
                        }
                    }
                });
    }

    /**
     * 处理首页推荐的数据 提供给View层
     *
     * @param mHomeRecommandData
     */
    protected void processRecommandData(HomeRecommandData mHomeRecommandData) {
        List<String> magicList = new ArrayList<>();
        // 指示器数据
        if (mHomeRecommandData.getArr_table_data() != null) {
            for (HomeRecommandData.ArrTableDataBean arrTableDataBean : mHomeRecommandData.getArr_table_data()) {
                magicList.add(arrTableDataBean.getString_title_cn());
            }
            mRootView.initMagicIndicatorView(magicList);
        }
        //判断banner是否为空
        if (mHomeRecommandData.getArr_index_banner_data() != null) {
            HRecommandMultiItemEntity bannerEntity = new HRecommandMultiItemEntity();
            bannerEntity.setArr_index_banner_data(mHomeRecommandData.getArr_index_banner_data());
            hRecommandMultiItemList.add(bannerEntity);
        }

        mRootView.processRecommandUiData(hRecommandMultiItemList);
        mRecommandAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
        this.hRecommandMultiItemList = null;
    }
}
