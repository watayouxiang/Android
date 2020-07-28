package com.watayouxiang.androidcode.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

public class Handler_basicUse2 implements View.OnClickListener {
    @Override
    public void onClick(final View v) {
        //Looper.getMainLooper()获取的是主线程的Looper
        //根据主线程Looper创建的Handler，当然也是运行在主线程中
        final Handler handler = new Handler(Looper.getMainLooper());

        new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程发消息
                handler.sendMessage(Message.obtain(handler, new Runnable() {
                    @Override
                    public void run() {
                        //这里是主线程，所以可以弹吐司
                        Toast.makeText(v.getContext(), "收到消息了", Toast.LENGTH_SHORT).show();
                    }
                }));
            }
        }).start();
    }
}
