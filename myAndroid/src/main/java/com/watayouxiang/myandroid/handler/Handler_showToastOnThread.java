package com.watayouxiang.myandroid.handler;

import android.os.Looper;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;

public class Handler_showToastOnThread implements View.OnClickListener {
    @Override
    public void onClick(final View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 在子线程创建 Looper
                Looper.prepare();

                // 在子线程中弹 Toast
                // 但不建议这么做，因为该子线程会阻塞在 Looper.loop() 方法处，导致线程结束不了，造成资源浪费
                ToastUtils.showShort(Thread.currentThread().getName() + ": 子线程弹Toast");

                // Looper开始消息轮询（阻塞式方法）
                Looper.loop();
            }
        }).start();
    }
}
