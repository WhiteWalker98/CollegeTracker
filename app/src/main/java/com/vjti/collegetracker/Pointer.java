package com.vjti.collegetracker;

/**
 * Created by Bisure on 28-06-2017.
 */

import android.support.annotation.Nullable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;



public class Pointer extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saved){
        myView = inflater.inflate(R.layout.pointer_fragment,container,false);
        return myView;
    }
}
