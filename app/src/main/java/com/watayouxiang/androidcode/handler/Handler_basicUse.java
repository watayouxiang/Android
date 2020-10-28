package com.watayouxiang.androidcode.handler;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;

import java.lang.ref.WeakReference;

public class Handler_basicUse implements View.OnClickListener {

    // WeakReference + static 避免内存泄漏
    private static class MyHandler extends Handler {
        private final WeakReference<Context> mReference;

        MyHandler(Context context) {
            mReference = new WeakReference<>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
            Object obj = msg.obj;
            Context context = mReference.get();
            if (context != null) {
                String txt = "what = " + what + ", obj = " + obj;
                ToastUtils.showShort(txt);
            }
        }
    }

    @Override
    public void onClick(View v) {
        // 创建 Handler
        final MyHandler myHandler = new MyHandler(v.getContext());
        // 子线程发送消息到主线程，从而实现"线程间通讯"
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = Message.obtain();
                message.what = 1001;
                message.obj = "我来啦";
                myHandler.sendMessage(message);
            }
        }).start();
    }
}
