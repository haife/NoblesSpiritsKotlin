package com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter;


import com.haife.app.nobles.spirits.kotlin.app.base.BaseSupportFragment;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/22
 * TODO: {@link HomeViewPagerAdapter}
 */
public class HomeViewPagerAdapter extends FragmentPagerAdapter {
    private List<BaseSupportFragment> mHomeFragmentList;

    public HomeViewPagerAdapter(FragmentManager fm, List<BaseSupportFragment> homeFragmentList) {
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


