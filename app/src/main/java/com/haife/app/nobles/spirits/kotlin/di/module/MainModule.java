package com.haife.app.nobles.spirits.kotlin.di.module;

import com.haife.app.nobles.spirits.kotlin.mvp.contract.MainContract;
import com.haife.app.nobles.spirits.kotlin.mvp.model.MainModel;
import com.jess.arms.di.scope.ActivityScope;
import com.tbruyelle.rxpermissions2.RxPermissions;

import dagger.Module;
import dagger.Provides;


@Module
public class MainModule {
    private MainContract.View view;

    /**
     * 构建MainModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public MainContract.View provideMainView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    public MainContract.Model provideMainModel(MainModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    RxPermissions provideRxPermission() {
        return new RxPermissions(view.getActivity());
    }



}