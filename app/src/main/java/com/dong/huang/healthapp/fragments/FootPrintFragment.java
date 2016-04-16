package com.dong.huang.healthapp.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dong.huang.healthapp.R;
import com.dong.huang.healthapp.beans.StepDetector;
import com.dong.huang.healthapp.service.StepService;
import com.dong.huang.healthapp.view.CircleBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class FootPrintFragment extends Fragment {

    private CircleBar circleBar;
    private Thread thread;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            circleBar.setProgress(StepDetector.CURRENT_SETP);
        }
    };

    public FootPrintFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_foot_print, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        circleBar = (CircleBar) view.findViewById(R.id.circleBar);
        circleBar.setProgress(1);
        mThread();
    }

    private void mThread() {
        if (thread == null) {
            thread = new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (StepService.flag) {
                            Message msg = Message.obtain();
                            handler.sendMessage(msg);
                        }
                    }
                }
            });
            thread.start();
        }
    }

}
