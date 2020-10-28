package com.watayouxiang.androidcode;

import com.watayouxiang.androidcode.animation.AnimationActivity;
import com.watayouxiang.androidcode.animation.AnimationDrawableActivity;
import com.watayouxiang.androidcode.animation.AnimatorActivity;
import com.watayouxiang.androidcode.animation.demo.TidaAnimatorDemo;
import com.watayouxiang.androidcode.handler.HandlerThread_basicUse;
import com.watayouxiang.androidcode.handler.HandlerThread_basicUse2;
import com.watayouxiang.androidcode.handler.Handler_basicUse;
import com.watayouxiang.androidcode.handler.Handler_basicUse2;
import com.watayouxiang.androidcode.handler.Handler_post;
import com.watayouxiang.androidcode.handler.Handler_runOnUIThread;
import com.watayouxiang.androidcode.handler.Handler_showToastOnThread;
import com.watayouxiang.androidcode.service.IntentServiceActivity;
import com.watayouxiang.androidcode.service.LocalServiceActivity;
import com.watayouxiang.androidcode.service.RemoteServiceActivity;
import com.watayouxiang.androidcode.view.TestViewActivity;
import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;

public class MainActivity extends ListActivity {

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
                .addWeb(this, "查看代码", "https://github.com/watayouxiang/Android/tree/master/app/src/main/java/com/watayouxiang/androidcode")
                .addSection("Handler")
                .addClick(new Handler_basicUse())
                .addClick(new Handler_basicUse2())
                .addClick(new Handler_runOnUIThread())
                .addClick(new Handler_post())
                .addClick(new Handler_showToastOnThread())
                .addClick(new HandlerThread_basicUse())
                .addClick(new HandlerThread_basicUse2())
                .addSection("View")
                .addActivity(this, TestViewActivity.class)
                .addSection("Service")
                .addActivity(this, IntentServiceActivity.class)
                .addActivity(this, LocalServiceActivity.class)
                .addActivity(this, RemoteServiceActivity.class)
                .addSection("Animation")
                .addActivity(this, AnimationDrawableActivity.class)
                .addActivity(this, AnimationActivity.class)
                .addActivity(this, AnimatorActivity.class)
                .addActivity(this, TidaAnimatorDemo.class)
                ;
    }
}
