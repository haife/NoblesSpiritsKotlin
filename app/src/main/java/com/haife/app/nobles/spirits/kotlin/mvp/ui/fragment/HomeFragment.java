package com.haife.app.nobles.spirits.kotlin.mvp.ui.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haife.app.nobles.spirits.kotlin.R;
import com.haife.app.nobles.spirits.kotlin.app.base.BaseSupportFragment;
import com.haife.app.nobles.spirits.kotlin.di.component.DaggerHomeComponent;
import com.haife.app.nobles.spirits.kotlin.di.module.HomeModule;
import com.haife.app.nobles.spirits.kotlin.mvp.contract.HomeContract;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.Token;
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi.HRecommandMultiItemEntity;
import com.haife.app.nobles.spirits.kotlin.mvp.presenter.HomePresenter;
import com.haife.app.nobles.spirits.kotlin.mvp.ui.widget.ScaleTransitionPagerTitleView;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * @author haife
 * @since 2018/12/18
 * TODO: HomeFragmentUI
 */
public class HomeFragment extends BaseSupportFragment<HomePresenter> implements HomeContract.View {
    @BindView(R.id.magic_indicator_home)
    MagicIndicator mHomeMagicIndicator;

    @BindView(R.id.view_pager_home_container)
    ViewPager mHomeViewPager;

    @Inject
    List<BaseFragment> mHomeFragmentList;
    private CommonNavigator mMIndicatorNavigator;
    private HomeViewPagerAdapter homeViewPagerAdapter;

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


    @Override
    public void post(Runnable runnable) {

    }

    @Override
    public void initMagicIndicatorView(List<String> magicIndicatorContentList) {
        mMIndicatorNavigator = new CommonNavigator(getContext());
        mMIndicatorNavigator.setLeftPadding(16);
        mMIndicatorNavigator.setRightPadding(16);
        mMIndicatorNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return magicIndicatorContentList == null ? 0 : magicIndicatorContentList.size();
            }

            @Override
            public IPagerTitleView getTitleView(final Context context, int index) {
                SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
                simplePagerTitleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21);
                simplePagerTitleView.setText(magicIndicatorContentList.get(index));
                simplePagerTitleView.setNormalColor(ContextCompat.getColor(context, R.color.black));
                simplePagerTitleView.setSelectedColor(ContextCompat.getColor(context, R.color.magic_indicator_text_color));
                simplePagerTitleView.setOnClickListener(v -> mHomeViewPager.setCurrentItem(index));
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                indicator.setLineHeight(10f);
                indicator.setColors(ContextCompat.getColor(context, R.color.black));
                return indicator;
            }
        });

        mHomeMagicIndicator.setNavigator(mMIndicatorNavigator);
        ViewPagerHelper.bind(mHomeMagicIndicator, mHomeViewPager);
        homeViewPagerAdapter = new HomeViewPagerAdapter(getFragmentManager());
        mHomeViewPager.setAdapter(homeViewPagerAdapter);
    }

    @Override
    public void processRecommandUiData(List<HRecommandMultiItemEntity> homeRecommandData) {

    }


    /**
     * TODO: ViewPagerDapter
     */
    public class HomeViewPagerAdapter extends FragmentPagerAdapter {
        public HomeViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return mHomeFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mHomeFragmentList.size();
        }
    }

}
