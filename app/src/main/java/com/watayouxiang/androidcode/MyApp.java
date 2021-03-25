package com.watayouxiang.androidcode;

import android.app.Application;

import com.blankj.utilcode.util.CrashUtils;
import com.blankj.utilcode.util.ProcessUtils;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/03/25
 *     desc   :
 * </pre>
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (ProcessUtils.isMainProcess()) {
            CrashUtils.init();
        }

    }
}
