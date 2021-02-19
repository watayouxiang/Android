package com.watayouxiang.androidcode.service;

import android.util.Log;

class LogUtil {
    private static final String TAG = "ServiceLog";

    static void d(String txt) {
        Log.d(TAG, String.valueOf(txt));
    }
}
