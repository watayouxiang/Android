package com.watayouxiang.myandroid.service.intent_service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.watayouxiang.myandroid.service.LogUtil;

import java.lang.ref.WeakReference;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 3/23/21
 *     desc   :
 *
 *     onCreate
 *     onStartCommand: data = Bundle数据
 *     onHandleIntent: data = Bundle数据（子线程）
 *     onStart
 *     onDestroy
 *
 * </pre>
 */
public class MyIntentService extends IntentService {

    public static final String KEY_DATA = "start";

    private final MyHandler handler = new MyHandler(this);

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
    public MyIntentService() {
        super("构造参数");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.d("onCreate");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        LogUtil.d("onStartCommand: data = " + intent.getStringExtra(KEY_DATA));
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 会创建独立的 worker 线程来处理 onHandleIntent() 方法实现的代码，处理耗时操作。
     * 请求处理完成后，IntentService 会自动停止，无需手动停止;
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        LogUtil.d("onHandleIntent: data = " + intent.getStringExtra(KEY_DATA));

        Message message = new Message();
        message.what = 1300;
        message.obj = "DelayMessage";
        handler.sendMessageDelayed(message, 3000);
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
        LogUtil.d("onBind: data = " + intent.getStringExtra(KEY_DATA));
        return super.onBind(intent);
    }
}
