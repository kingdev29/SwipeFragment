package com.example.pouya.myapplication.Fragment;


import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pouya.myapplication.R;
import com.example.pouya.myapplication.controller.SwipeFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends android.app.Fragment {


    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        view.setBackgroundColor(Color.DKGRAY);
        view.setOnTouchListener(new SwipeFragment(getFragmentManager(), fragmentTransaction, this));
        // Inflate the layout for this fragment
        return view;

    }

}
