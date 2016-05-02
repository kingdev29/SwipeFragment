package com.example.pouya.myapplication.Fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pouya.myapplication.R;
import com.example.pouya.myapplication.controller.SwipeFragment;


public class SecondFragment extends Fragment {

    View view;
    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_second, container, false);
        view.setBackgroundColor(Color.BLUE);
        view.setOnTouchListener(new SwipeFragment());
        return view;

    }

}
