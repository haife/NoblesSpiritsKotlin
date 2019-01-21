package com.haife.app.nobles.spirits.kotlin.mvp.presenter;

import android.app.Application;
import android.view.View;

import com.haife.app.nobles.spirits.kotlin.mvp.contract.HomeContract;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.BaseResponse;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.Token;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi.HRecommendMultiItemEntity;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommendData;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.RestaurantUnionBean;
import com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter.HRecommendAdapter;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.RxLifecycleUtils;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.exceptions.CompositeException;
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
    AppManager mAppManager;
    @Inject
    RestaurantUnionBean mRestaurantUnionBean;
    @Inject
    HomeRecommendData mHomeRecommendData;
    @Inject
    List<HRecommendMultiItemEntity> hRecommendMultiItemList;
    @Inject
    HRecommendAdapter mRecommendAdapter;
    @Inject
    View netErrorView;
    @Inject
    Token mToken;

    private final String HOME_FRAGMENT_SIMPLE_NAME = "HomeFragment";
    private final String HOME_RECOMMEND_FRAGMENT_SIMPLE_NAME = "HRecommendFragment";

    @Inject
    public HomePresenter(HomeContract.Model model, HomeContract.View rootView) {
        super(model, rootView);
    }

    /**
     * 使用 2017 Google IO 发布的 Architecture Components 中的 Lifecycles 的新特性 (此特性已被加入 Support library)
     * 使 {@code Presenter} 可以与 {@link com.haife.app.nobles.spirits.kotlin.app.base.BaseSupportActivity} 和 {@link com.haife.app.nobles.spirits.kotlin.app.base.BaseSupportFragment} 的部分生命周期绑定
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {

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
     * @param fragmentName  请求的fragment实例 HomeFragment、hRecommendFragment
     * @param pullToRefresh 是否是下拉刷新
     */
    public void getHomeRecommendData(String fragmentName, boolean pullToRefresh) {
        boolean isEvictCache = pullToRefresh;
        mModel.getHomeRecommendData(mToken, isEvictCache).compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retryWhen(new RetryWithDelay(3, 2))
                .subscribe(new ErrorHandleSubscriber<BaseResponse<HomeRecommendData>>(mErrorHandler) {
                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        if (t instanceof CompositeException) {
                            for (int i = 0; i < ((CompositeException) t).getExceptions().size(); i++) {
                                Throwable throwable = ((CompositeException) t).getExceptions().get(i);
                                if (throwable instanceof UnknownHostException || throwable instanceof SocketTimeoutException) {
                                    if (fragmentName.equals(HOME_FRAGMENT_SIMPLE_NAME))
                                        mRootView.netWorkError();
                                }
                            }
                        }

                    }

                    @Override
                    public void onNext(BaseResponse<HomeRecommendData> response) {
                        if (response.getData().isSuccess()) {
                            mHomeRecommendData = response.getData().getResult();
                            if (fragmentName.equals(HOME_FRAGMENT_SIMPLE_NAME)) {
                                processHomeData();
                            } else if (fragmentName.equals(HOME_RECOMMEND_FRAGMENT_SIMPLE_NAME)) {
                                if (pullToRefresh) {
                                    hRecommendMultiItemList.clear();
                                }
                                processRecommendData();
                            }
                        } else {
                            mRootView.showMessage(response.getData().getMsg());
                        }
                    }
                });
    }

    /**
     * TODO 初始化RecommendFragmentIndicator
     */
    private void processHomeData() {
        List<String> magicList = new ArrayList<>();
        if (mHomeRecommendData.getArr_table_data() != null) {
            for (int i = 0; i < mHomeRecommendData.getArr_table_data().size(); i++) {
                magicList.add(mHomeRecommendData.getArr_table_data().get(i).getString_title_cn());
            }
        }
        mRootView.initMagicIndicatorView(magicList);
        netErrorView.setVisibility(View.GONE);
    }


    /**
     * TODO 处理首页推荐的数据 提供给View层
     */
    private void processRecommendData() {
        //判断banner是否为空
        if (mHomeRecommendData.getArr_index_banner_data() != null && mHomeRecommendData.getArr_index_banner_data().size() != 0) {
            HRecommendMultiItemEntity bannerEntity = new HRecommendMultiItemEntity(HRecommendMultiItemEntity.STRING_BANNER_TYPE);
            bannerEntity.setBannerData(mHomeRecommendData.getArr_index_banner_data());
            hRecommendMultiItemList.add(bannerEntity);
        }
        //实体类处理
        if (mHomeRecommendData.getArr_module_data() != null) {
            for (int i = 0; i < mHomeRecommendData.getArr_module_data().size(); i++) {
                if (mHomeRecommendData.getArr_module_data().get(i).getArr_data() != null && mHomeRecommendData.getArr_module_data().get(i).getArr_data().size() > 0) {
                    String typeModuleStr = mHomeRecommendData.getArr_module_data().get(i).getArr_title_data().getSting_module_name();
                    HRecommendMultiItemEntity recommendShopEntity = new HRecommendMultiItemEntity(typeModuleStr);
                    recommendShopEntity.setArr_data(mHomeRecommendData.getArr_module_data().get(i).getArr_data());
                    recommendShopEntity.setArr_title_data(mHomeRecommendData.getArr_module_data().get(i).getArr_title_data());
                    hRecommendMultiItemList.add(recommendShopEntity);
                }
            }
            mRecommendAdapter.notifyDataSetChanged();
        }


    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mApplication = null;
        this.hRecommendMultiItemList = null;
        this.mRecommendAdapter = null;
        this.mHomeRecommendData = null;
    }

}
