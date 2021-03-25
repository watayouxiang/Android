package com.watayouxiang.myandroid;

import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;
import com.watayouxiang.myandroid.animation.AnimationDemo;
import com.watayouxiang.myandroid.broadcast_receiver.BroadcastDemoActivity;
import com.watayouxiang.myandroid.handler.HandlerDemo;
import com.watayouxiang.myandroid.service.ServiceDemo;
import com.watayouxiang.myandroid.view.ViewDemo;

public class MyAndroidDemo extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addActivity(this, AnimationDemo.class)
                .addActivity(this, HandlerDemo.class)
                .addActivity(this, ServiceDemo.class)
                .addActivity(this, ViewDemo.class)
                .addActivity(this, BroadcastDemoActivity.class)
                ;
    }
}
