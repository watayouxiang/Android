package com.watayouxiang.androiddemo;

import com.watayouxiang.androiddemo.animation.AnimationDemoActivity;
import com.watayouxiang.androiddemo.handler.HandlerDemoActivity;
import com.watayouxiang.androiddemo.provider.demo.ui.ContentProviderDemoActivity;
import com.watayouxiang.androiddemo.receiver.BroadcastDemoActivity;
import com.watayouxiang.androiddemo.service.ServiceDemoActivity;
import com.watayouxiang.androiddemo.view.ViewDemoActivity;
import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;

public class MainActivity extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addActivity(this, AnimationDemoActivity.class)
                .addActivity(this, HandlerDemoActivity.class)
                .addActivity(this, ServiceDemoActivity.class)
                .addActivity(this, ViewDemoActivity.class)
                .addActivity(this, BroadcastDemoActivity.class)
                .addActivity(this, ContentProviderDemoActivity.class)
                ;
    }
}
