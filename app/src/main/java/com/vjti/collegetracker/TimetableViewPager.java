package com.vjti.collegetracker;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by sanidhya on 4/1/18.
 */

public class TimetableViewPager extends FragmentPagerAdapter {

    public TimetableViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0 :
            case 1 :
            case 2 :
            case 3 :
            case 4 :
            case 5 :
            case 6 : return new DayFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "MON";
            case 1: return "TUE";
            case 2: return "WED";
            case 3: return "THU";
            case 4: return "FRI";
            case 5: return "SAT";
            case 6: return "SUN";
        }
        return null;
    }
}