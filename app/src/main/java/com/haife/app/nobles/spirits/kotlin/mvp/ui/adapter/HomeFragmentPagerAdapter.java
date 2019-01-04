package com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jess.arms.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

/**
 * @ author haife
 * @ since 2019/1/4
 * TODO：
 */
public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
    @Inject
    List<BaseFragment> mHomeFragmentList;

    public HomeFragmentPagerAdapter(FragmentManager fm, List<BaseFragment> homeFragmentList) {
        super(fm);
        this.mHomeFragmentList = homeFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mHomeFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mHomeFragmentList.size();
    }
}
