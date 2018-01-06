package com.vjti.collegetracker;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sanidhya on 3/1/18.
 */

public class HomeFragment extends Fragment {

    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v= inflater.inflate(R.layout.fragment_home,container,false);
        viewPager = (ViewPager) v.findViewById(R.id.time_table_view_pager);
        Log.i("DEBUG","value of viewPager"+(viewPager == null));
        viewPager.setAdapter(new TimetableViewPager(getChildFragmentManager()));
        viewPager.setOffscreenPageLimit(2);
        Log.i("DEBUG","Inside HomeFragment");
        return v;
    }
}
