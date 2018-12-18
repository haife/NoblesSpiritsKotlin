package com.haife.app.nobles.spirits.kotlin.mvp.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haife.app.nobles.spirits.kotlin.R;
import com.haife.app.nobles.spirits.kotlin.app.base.BaseSupportFragment;
import com.haife.app.nobles.spirits.kotlin.di.component.DaggerHomeComponent;
import com.haife.app.nobles.spirits.kotlin.di.module.HomeModule;
import com.haife.app.nobles.spirits.kotlin.mvp.contract.HomeContract;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.Token;
import com.haife.app.nobles.spirits.kotlin.mvp.presenter.HomePresenter;
import com.jess.arms.di.component.AppComponent;

/**
 * @author haife
 * @since 2018/12/18
 * TODO: HomeFragmentUI
 */
public class HomeFragment extends BaseSupportFragment<HomePresenter> implements HomeContract.View {


    @Override
    public void initWidget() {

    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerHomeComponent.builder().appComponent(appComponent)
                .homeModule(new HomeModule(this))
                .build().inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        Token token = new Token();
        initWidget();
        mPresenter.getHomeUnionRestaurant(token);
        mPresenter.getHomeRecommandData(token);
    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void launchActivity(@NonNull Intent intent) {

    }

    @Override
    public void killMyself() {

    }
}
