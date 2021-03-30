package com.watayouxiang.androiddemo.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;

public class Handler_basicUse2 implements View.OnClickListener {
    @Override
    public void onClick(final View v) {
        // Looper.getMainLooper()获取的是主线程的Looper
        // 根据主线程 Looper 创建的 Handler，当然也是运行在主线程中
        final Handler handler = new Handler(Looper.getMainLooper());

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 子线程发消息
                handler.sendMessage(Message.obtain(handler, new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.showShort(Thread.currentThread().getName() + ": 收到消息了");
                    }
                }));
            }
        }).start();
    }
}
