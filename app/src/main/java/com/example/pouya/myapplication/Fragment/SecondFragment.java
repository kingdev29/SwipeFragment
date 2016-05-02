package com.example.pouya.myapplication.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pouya.myapplication.R;
import com.example.pouya.myapplication.controller.SwipeFragment;


public class SecondFragment extends Fragment implements View.OnClickListener {

    View view;
    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        view = inflater.inflate(R.layout.fragment_second, container, false);
        Button otherFragmentBtn = (Button) view.findViewById(R.id.btn_otherFragment);
        otherFragmentBtn.setOnClickListener(this);
        view.setBackgroundColor(Color.GRAY);
        view.setOnTouchListener(new SwipeFragment(getFragmentManager(),fragmentTransaction, this));
        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_otherFragment:
                ThirdFragment thirdFragment = new ThirdFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.thirdFragment, thirdFragment,"thirdFragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
    }
}
