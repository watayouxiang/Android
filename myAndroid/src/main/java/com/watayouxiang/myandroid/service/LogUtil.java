package com.watayouxiang.myandroid.service;

import android.util.Log;

public class LogUtil {
    private static final String TAG = "ServiceLog";

    public static void d(String txt) {
        Log.d(TAG, String.valueOf(txt));
    }
}
