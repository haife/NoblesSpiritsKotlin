package com.haife.app.nobles.spirits.kotlin.di.module;

import com.haife.app.nobles.spirits.kotlin.mvp.contract.HomeContract;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi.HRecommandMultiItemEntity;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommandData;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.RestaurantUnionBean;
import com.haife.app.nobles.spirits.kotlin.mvp.model.HomeModel;
import com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter.HRecommandAdapter;
import com.haife.app.nobles.spirits.kotlin.mvp.ui.fragment.HRecommandFragment;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.scope.FragmentScope;

import org.jetbrains.annotations.NotNull;

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
    HomeRecommandData provideHomeRecommandData() {
        return new HomeRecommandData();
    }

    @FragmentScope
    @Provides
    List<BaseFragment> provideHomeFragmentList() {
        List<BaseFragment> fragmentList = new ArrayList<>();
        fragmentList.add(HRecommandFragment.Companion.newInstance());
        return fragmentList;
    }

    @FragmentScope
    @Provides
    List<HRecommandMultiItemEntity> provideRecommandDataList() {
        return new ArrayList<>();
    }

    @FragmentScope
    @Provides
    HRecommandAdapter provideHRecommandAdapter(@NotNull List<HRecommandMultiItemEntity> list){
        return new HRecommandAdapter(list);
    }
}
