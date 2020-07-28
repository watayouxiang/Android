package com.watayouxiang.androidcode;

import com.watayouxiang.androidcode.animation.FrameAnimationActivity;
import com.watayouxiang.androidcode.animation.PropertyAnimationActivity;
import com.watayouxiang.androidcode.animation.TidaAnimatorDemo;
import com.watayouxiang.androidcode.animation.TweenAnimationActivity;
import com.watayouxiang.androidcode.handler.*;
import com.watayouxiang.androidcode.service.IntentServiceActivity;
import com.watayouxiang.androidcode.service.LocalServiceActivity;
import com.watayouxiang.androidcode.service.RemoteServiceActivity;
import com.watayouxiang.androidcode.view.TestViewActivity;
import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;

public class TestActivity extends ListActivity {
    private static final String GITHUB_URL = "https://github.com/watayouxiang/AndroidDemo/tree/master";
    private static final String ANDROID_BASE_URL = GITHUB_URL + "/app/src/main/java/com/watayouxiang/android";
    private static final String README = GITHUB_URL + "/README.md";

    @Override
    protected boolean showBackBtn() {
        return false;
    }

    @Override
    protected CharSequence getPageTitle() {
        return getResources().getString(R.string.app_name);
    }

    @Override
    protected ListData getListData() {
        return new ListData()
                .addWeb(this, README)
                .addSection("View")
                .addActivity(this, TestViewActivity.class)
                .addSection("Service")
                .addActivity(this, IntentServiceActivity.class)
                .addActivity(this, LocalServiceActivity.class)
                .addActivity(this, RemoteServiceActivity.class)
                .addSection("Animation")
                .addActivity(this, FrameAnimationActivity.class)
                .addActivity(this, TweenAnimationActivity.class)
                .addActivity(this, PropertyAnimationActivity.class)
                .addActivity(this, TidaAnimatorDemo.class)
                .addSection("Handler")
                .addWeb(this, ANDROID_BASE_URL + "/handler/Handler消息机制.md")
                .addClick(new Handler_basicUse())
                .addClick(new Handler_basicUse2())
                .addClick(new Handler_runOnUIThread())
                .addClick(new Handler_post())
                .addWeb(this, ANDROID_BASE_URL + "/handler/HandlerThread介绍.md")
                .addClick(new Handler_showToastOnThread())
                .addClick(new HandlerThread_basicUse())
                .addClick(new HandlerThread_basicUse2())
                ;
    }
}
