package com.anhtd.instantship.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anhtd on 5/27/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mTitle = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments != null ? mFragments.get(position) : null;
    }

    @Override
    public int getCount() {
        return mFragments != null ? mFragments.size() : 0;
    }

    public void addFragment(Fragment frag, String title) {
        mFragments.add(frag);
        mTitle.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
