package com.watayouxiang.myandroid.handler;

import android.app.Activity;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;

public class Handler_runOnUIThread implements View.OnClickListener {
    @Override
    public void onClick(final View v) {
        final Activity activity = getActivity(v);
        if (activity == null) return;

        // 用 Activity 对象的 runOnUiThread 方法
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showShort("activity.runOnUiThread(Runnable r)");
            }
        });
    }

    private Activity getActivity(View v) {
        if (v.getContext() instanceof Activity) {
            return (Activity) v.getContext();
        }
        return null;
    }
}
