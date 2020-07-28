package com.watayouxiang.androidcode.handler;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;

public class HandlerThread_basicUse2 implements View.OnClickListener {
    private String TAG = getClass().getSimpleName();
    private final Handler mMyHandler;
    private final MyHandlerThread mMyHandlerThread;

    public HandlerThread_basicUse2() {
        //创建并开启 handlerThread
        mMyHandlerThread = new MyHandlerThread("<<MyThread>>");
        mMyHandlerThread.start();
        //只有开启线程后，调 handlerThread.getLooper() 才有值
        mMyHandler = new Handler(mMyHandlerThread.getLooper());
    }

    //定义 handlerThread 线程
    private class MyHandlerThread extends HandlerThread {
        MyHandlerThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            Log.d(TAG, Thread.currentThread().getName() + ": run start");
            super.run();
            Log.d(TAG, Thread.currentThread().getName() + ": run end");
        }
    }

    @Override
    public void onClick(final View v) {
        Log.d(TAG, Thread.currentThread().getName() + ": 发送消息");
        mMyHandler.sendMessage(Message.obtain(mMyHandler, new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, Thread.currentThread().getName() + ": 收到消息");
            }
        }));
    }

    /**
     * 销毁HandlerThread
     */
    public void releaseRes() {
        //handlerThread线程变量中的Looper关闭，线程也会退出
        mMyHandlerThread.quit();
    }

}
