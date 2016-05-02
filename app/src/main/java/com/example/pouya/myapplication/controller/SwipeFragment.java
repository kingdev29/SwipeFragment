package com.example.pouya.myapplication.controller;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.pouya.myapplication.Fragment.SecondFragment;
import com.example.pouya.myapplication.Fragment.ThirdFragment;


public class SwipeFragment implements View.OnTouchListener {

    int startX;
    int currenX;
    boolean dragging = false;
    FragmentTransaction fragmentTransaction;
    SecondFragment secondFragment;
    ThirdFragment thirdFragment;
    String fragmentTag;
    FragmentManager fragmentManager;

    public SwipeFragment (FragmentManager fragmentManager, FragmentTransaction fragmentTransaction, SecondFragment secondFragment){
        this.fragmentTransaction = fragmentTransaction;
        this.secondFragment = secondFragment;
        fragmentTag = secondFragment.getTag();
        this.fragmentManager = fragmentManager;

    }

    public SwipeFragment(FragmentManager fragmentManager, FragmentTransaction fragmentTransaction, ThirdFragment thirdFragment) {
        this.thirdFragment = thirdFragment;
        this.fragmentTransaction = fragmentTransaction;
        fragmentTag = thirdFragment.getTag();
        this.fragmentManager = fragmentManager;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        final int X = (int) event.getRawX();

        if (!dragging){

            if (event.getAction() == MotionEvent.ACTION_DOWN && event.getX() < v.getWidth()){
                currenX = 0;
                startX = X;
                return true;
            }
        }
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_UP:
                if (X - startX > (v.getWidth()/2)) {
                    v.animate().x(v.getWidth());
                    destroyFragment();
                }
                else {
                    v.animate().x(0);
                }
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:

                if (X - startX >= 0) {

                    v.setTranslationX(X - startX);
                }
                else {
                    if (v.getX() > 0){
                        Log.d("diver", v.getX()+"");
                        v.setTranslationX(0);
                    }
                }
                break;

        }

        v.invalidate();

        return true;
    }

    private void destroyFragment() {
        switch (fragmentTag)
        {
            case "secondFragment" :
                if (fragmentManager.getBackStackEntryCount() != 0){
                    fragmentManager.popBackStack();
                }
//                fragmentTransaction.remove(secondFragment);
//                fragmentTransaction.commit();
                break;

            case "thirdFragment" :
//                fragmentTransaction.remove(thirdFragment);
//                fragmentTransaction.commit();
                if (fragmentManager.getBackStackEntryCount() != 0){
                    fragmentManager.popBackStack();
                }
        }
    }
}
