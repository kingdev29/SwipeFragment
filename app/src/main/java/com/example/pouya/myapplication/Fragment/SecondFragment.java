package com.example.pouya.myapplication.Fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.pouya.myapplication.R;


public class SecondFragment extends Fragment {

    View view;
    private int _xDelta;
    boolean dragging = false;
    int currenX;
    int startX;
    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_second, container, false);
        view.setBackgroundColor(Color.BLUE);

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                    final int X = (int) event.getRawX();

                if (!dragging){

                    if (event.getAction() == MotionEvent.ACTION_DOWN && event.getX() < container.getChildAt(0).getWidth()){
                        currenX = 0;
                        startX = X;
                        return true;
                    }
                }
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_DOWN:
                            FrameLayout.LayoutParams lParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                            _xDelta = X - lParams.leftMargin;

                            break;
                        case MotionEvent.ACTION_UP:
                            if (X - startX > (container.getChildAt(0).getWidth()/2)) {
                                view.animate().x(container.getChildAt(0).getWidth());
                            }
                            else {
                                view.animate().x(0);
                            }
                            break;
                        case MotionEvent.ACTION_POINTER_DOWN:
                            break;
                        case MotionEvent.ACTION_POINTER_UP:
                            break;
                        case MotionEvent.ACTION_MOVE:

                            _xDelta = (int) event.getX();
//                            Log.d("testLog", view.getX()+"");
                            if (X - startX >= 0) {
                                view.setTranslationX(X - startX);
                            }
                            else {
                                if (view.getX() > 0){
                                    Log.d("diver", view.getX()+"");
                                    view.setTranslationX(0);
                                }
                            }
//                        layoutParams.topMargin = Y - _yDelta;
//                        layoutParams.rightMargin = -250;
//                        layoutParams.bottomMargin = -250;
//                            v.setLeft(X - _xDelta);
                            break;

                    }

                view.invalidate();

                return true;
            }
        });

        return view;

    }

}
