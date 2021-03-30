package com.watayouxiang.androiddemo.receiver;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/03/24
 *     desc   :
 *
 *     静态注册广播：
 *     清单文件中注册，当程序关闭后，如果有信息广播来，程序也会被系统自动运行。
 *     一旦程序安装在手机上，广播接收者就会生效
 *
 *     动态注册广播：
 *     动态注册的广播，它不是常驻广播，也就是说广播随着程序的生命周期。
 *
 * </pre>
 */
public class BroadcastDemoActivity extends Activity {

    private DateChangedReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 动态注册广播
        // 广播接受者随着app
        receiver = new DateChangedReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_DATE_CHANGED);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
