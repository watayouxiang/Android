package com.watayouxiang.androidcode;

import com.watayouxiang.androidcode.activity._Activity;
import com.watayouxiang.androidcode.animation._Animation;
import com.watayouxiang.androidcode.handler._Handler;
import com.watayouxiang.androidcode.others._Others;
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
                .addWeb(this, "view code", Const.app_java_dir)
                .addActivity(this, _Activity.class)
                .addActivity(this, _Animation.class)
                .addActivity(this, _Handler.class)
                .addActivity(this, _Others.class)
                ;
    }
}