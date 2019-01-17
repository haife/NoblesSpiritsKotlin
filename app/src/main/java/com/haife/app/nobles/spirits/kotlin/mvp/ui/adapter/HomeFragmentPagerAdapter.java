package com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter;


import com.jess.arms.base.BaseFragment;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * @ author haife
 * @ since 2019/1/4
 * TODO：
 */
public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> mHomeFragmentList;

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
