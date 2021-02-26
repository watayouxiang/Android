package com.watayouxiang.myandroid.service.local_service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.watayouxiang.myandroid.service.LogUtil;

/**
 * 隐式启动：
 * startService(intent);
 * stopService(intent);
 * onCreate -> onStartCommand -> onStart -> onDestroy
 * <p>
 * 绑定启动：
 * bindService(intent, connection, BIND_AUTO_CREATE);
 * unbindService(connection);
 * onCreate -> onBind -> onUnbind -> onDestroy
 */
public class LocalService extends Service {
    //创建
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.d("onCreate");
        //创建广播
        receiver = new ScreenBroadcastReceiver();
        //创建 IntentFilter 对象，并指定接收什么广播
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        //注册广播接收者
        registerReceiver(receiver, filter);
    }

    //绑定
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtil.d("onBind");
        return new MyBinder();
    }

    //解绑
    @Override
    public boolean onUnbind(Intent intent) {
        LogUtil.d("onUnbind");
        return super.onUnbind(intent);
    }

    //启动（过时方式）
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        LogUtil.d("onStart");
    }

    //启动
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.d("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    //销毁
    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("onDestroy");
        if (receiver != null) {
            unregisterReceiver(receiver);
        }
    }

    //重绑
    @Override
    public void onRebind(Intent intent) {
        LogUtil.d("onRebind");
        super.onRebind(intent);
    }

    // ================================================================
    // 服务
    // ================================================================

    private void playMusic() {
        LogUtil.d("音乐开始播放");
    }

    private class MyBinder extends Binder implements Api {
        @Override
        public void playMusic() {
            LocalService.this.playMusic();
        }
    }

    public interface Api {
        void playMusic();
    }

    // ================================================================
    // 广播
    // ================================================================

    private ScreenBroadcastReceiver receiver;

    private class ScreenBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Intent.ACTION_SCREEN_OFF.equals(action)) {
                String threadInfo = Thread.currentThread().toString();
                LogUtil.d(threadInfo + " 熄屏");
            } else if (Intent.ACTION_SCREEN_ON.equals(action)) {
                String threadInfo = Thread.currentThread().toString();
                LogUtil.d(threadInfo + " 亮屏");
            }
        }
    }
}
