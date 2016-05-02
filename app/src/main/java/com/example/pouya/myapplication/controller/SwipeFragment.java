package com.example.pouya.myapplication.controller;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class SwipeFragment implements View.OnTouchListener {

    int startX;
    int currenX;
    boolean dragging = false;

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
}
