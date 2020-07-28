package com.watayouxiang.androidcode.handler;

import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Handler_showToastOnThread implements View.OnClickListener {
    /**
     * 在子线程中弹Toast
     *
     * @param v
     */
    @Override
    public void onClick(final View v) {
        Thread thread = new Thread(new Runnable() {
            String TAG = "TAG";

            @Override
            public void run() {
                //在子线程创建Looper
                Looper.prepare();
                Log.e(TAG, "-- run 0 --");

                //在子线程中弹Toast
                //但不建议这么做，因为该子线程会阻塞在Looper.loop()方法处，导致线程结束不了，造成资源浪费
                Toast.makeText(v.getContext(), "子线程弹Toast", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "-- run 1 --");

                //Looper开始消息轮询
                Looper.loop();
                Log.e(TAG, "-- run 2 --");
            }
        });
        thread.start();
    }
}
