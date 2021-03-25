package com.watayouxiang.myandroid.content_provider.demo.db;

import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;

/**
 * Created by johnny on 2016/10/24.
 * <p>
 * 数据变化观察者
 */
public class PersonObserver extends ContentObserver {

    private final Handler handler;

    private static final int WHAT = 100;

    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     */
    public PersonObserver(Handler handler) {
        super(handler);
        this.handler = handler;
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        Message msg = Message.obtain();
        msg.what = WHAT;
        handler.sendMessage(msg);
    }
}
