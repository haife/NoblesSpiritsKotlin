package com.haife.app.nobles.spirits.kotlin.di.module;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.haife.app.nobles.spirits.kotlin.mvp.contract.HomeContract;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi.HRecommendMultiItemEntity;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommendData;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.RestaurantUnionBean;
import com.haife.app.nobles.spirits.kotlin.mvp.model.HomeModel;
import com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter.HRecommendAdapter;
import com.haife.app.nobles.spirits.kotlin.mvp.ui.fragment.HRecommendFragment;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.scope.FragmentScope;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * @ author haife
 * @ since 2018/12/18
 * TODO：
 */
@Module
public class HomeModule {

    private HomeContract.View view;
    public HomeModule(HomeContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    public HomeContract.View provideHomeView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    public HomeContract.Model provideHomeModel(HomeModel model) {
        return model;
    }


    @FragmentScope
    @Provides
    RestaurantUnionBean provideRestaurantUnionBean() {
        return new RestaurantUnionBean();
    }

    @FragmentScope
    @Provides
    HomeRecommendData provideHomeRecommendData() {
        return new HomeRecommendData();
    }

    @FragmentScope
    @Provides
    RecyclerView.LayoutManager provideLayoutManager(){
        return new LinearLayoutManager(view.getFragment().getContext());
    }

    @FragmentScope
    @Provides
    List<BaseFragment> provideHomeFragmentList() {
        List<BaseFragment> fragmentList = new ArrayList<>();
        fragmentList.add(HRecommendFragment.Companion.newInstance());
        return fragmentList;
    }

    @FragmentScope
    @Provides
    List<HRecommendMultiItemEntity> provideRecommendDataList() {
        return new ArrayList<>();
    }

    @FragmentScope
    @Provides
    HRecommendAdapter provideHRecommendAdapter(List<HRecommendMultiItemEntity> list){
        return new HRecommendAdapter(list,view.getFragment().getActivity());
    }
}
