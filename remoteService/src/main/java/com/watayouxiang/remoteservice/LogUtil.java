package com.watayouxiang.remoteservice;

import android.util.Log;

class LogUtil {
    private static final String TAG = "ServiceLog";

    static void d(String txt) {
        Log.d(TAG, String.valueOf(txt));
    }
}
