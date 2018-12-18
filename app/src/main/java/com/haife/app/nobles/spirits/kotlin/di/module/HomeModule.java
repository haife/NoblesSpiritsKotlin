package com.haife.app.nobles.spirits.kotlin.di.module;

import com.haife.app.nobles.spirits.kotlin.mvp.contract.HomeContract;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommandData;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.RestaurantUnionBean;
import com.haife.app.nobles.spirits.kotlin.mvp.model.HomeModel;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.di.scope.FragmentScope;

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



    @ActivityScope
    @Provides
    RestaurantUnionBean provideRestaurantUnionBean() {
        return new RestaurantUnionBean();
    }

    @ActivityScope
    @Provides
    HomeRecommandData provideHomeRecommandData() {
        return new HomeRecommandData();
    }

}
