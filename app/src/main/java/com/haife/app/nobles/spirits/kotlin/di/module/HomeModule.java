package com.haife.app.nobles.spirits.kotlin.di.module;


import android.view.LayoutInflater;
import android.view.View;

import com.haife.app.nobles.spirits.kotlin.R;
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

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
    RecyclerView.LayoutManager provideLayoutManager() {
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
    HRecommendAdapter provideHRecommendAdapter(List<HRecommendMultiItemEntity> list) {
        return new HRecommendAdapter(list, view.getFragment().getActivity());
    }

    @FragmentScope
    @Provides
    View provideNetErrorUiView() {
        return LayoutInflater.from(view.getFragment().getContext()).inflate(R.layout.include_home_recommend_net_wort_error, null);
    }


}
