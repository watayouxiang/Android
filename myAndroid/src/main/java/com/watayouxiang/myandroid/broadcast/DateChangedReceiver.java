package com.watayouxiang.myandroid.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/03/24
 *     desc   : 静态广播
 * </pre>
 */
public class DateChangedReceiver extends BroadcastReceiver {
    private static final String TAG = "BroadcastTag";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "日期发生变化了");
    }
}
