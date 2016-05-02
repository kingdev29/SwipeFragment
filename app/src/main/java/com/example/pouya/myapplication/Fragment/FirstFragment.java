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


public class FirstFragment extends android.app.Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);
        Button otherFragmentBtn = (Button) rootView.findViewById(R.id.btn_otherFragment);
        otherFragmentBtn.setOnClickListener(this);
        rootView.setBackgroundColor(Color.LTGRAY);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        Fragment secondFragment = new SecondFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.setCustomAnimations()
        fragmentTransaction.replace(R.id.secondFragment, secondFragment,"secondFragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
