package com.watayouxiang.androiddemo.service;

import android.util.Log;

import java.util.Locale;

public class LogUtil {
    private static final String TAG = "ServiceLog";

    public static void d(String txt) {
        Log.d(TAG, String.format(Locale.getDefault(), "[线程名:%s] %s", Thread.currentThread().getName(), txt));
    }
}
