package com.example.pouya.myapplication;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.pouya.myapplication.Fragment.FirstFragment;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.app.Fragment firstFragment = new FirstFragment();
        FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.firstFragment, firstFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() != 0){
            getFragmentManager().popBackStack();
        }
        else {
            finish();
        }
    }
}
