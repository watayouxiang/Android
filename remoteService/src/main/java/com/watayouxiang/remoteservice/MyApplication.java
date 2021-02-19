package com.watayouxiang.remoteservice;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

public class MyApplication extends Application {
    private static Context context;
    private static Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
    }

    public static Handler getHandler() {
        return handler;
    }

    public static Context getContext() {
        return context;
    }
}
