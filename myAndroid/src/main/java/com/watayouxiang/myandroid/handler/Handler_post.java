package com.watayouxiang.myandroid.handler;

import android.view.View;

import com.blankj.utilcode.util.ToastUtils;

public class Handler_post implements View.OnClickListener {
    @Override
    public void onClick(final View v) {
        v.post(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showShort("view.post(Runnable r)");
            }
        });
    }
}
