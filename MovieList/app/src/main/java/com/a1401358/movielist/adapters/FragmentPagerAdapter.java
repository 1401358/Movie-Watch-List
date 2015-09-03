package com.a1401358.movielist.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.a1401358.movielist.fragments.MoviesFragment;
import com.a1401358.movielist.fragments.TimeLineFragment;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TimeLineFragment();
            default:
                return new MoviesFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Time Line";
            default:
                return "Movies";

        }
    }
}
