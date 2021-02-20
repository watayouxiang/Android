package com.watayouxiang.myandroid.service.intent_service;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.watayouxiang.myandroid.service.LogUtil;

import java.lang.ref.WeakReference;

public class IntentService extends android.app.IntentService {
    private MyHandler handler = new MyHandler(this);

    private static class MyHandler extends Handler {
        private final WeakReference<Context> reference;

        MyHandler(Context context) {
            reference = new WeakReference<>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String info = "what=" + msg.what + ", obj=" + msg.obj;
            LogUtil.d(info);
            if (reference.get() != null) {
                Toast.makeText(reference.get(), info, Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 这里必须要有无参构造函数，否则：RuntimeException
     */
    public IntentService() {
        super("IntentServiceDemo");
    }

    /**
     * 会创建独立的 worker 线程来处理 onHandleIntent() 方法实现的代码，处理耗时操作。
     * 请求处理完成后，IntentService 会自动停止，无需手动停止;
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        LogUtil.d("onHandleIntent: threadName=" + Thread.currentThread().getName());

        Message message = new Message();
        message.what = 1300;
        message.obj = "DelayMessage";
        handler.sendMessageDelayed(message, 3000);
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        assert intent != null;
        LogUtil.d("onStartCommand: intent=" + intent.getStringExtra("start")
                + ", threadName=" + Thread.currentThread().getName());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.d("onCreate");
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
        LogUtil.d("onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtil.d("onBind");
        return super.onBind(intent);
    }
}
