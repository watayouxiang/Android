package com.watayouxiang.myandroid;

import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;
import com.watayouxiang.myandroid.activity._Activity;
import com.watayouxiang.myandroid.animation._Animation;
import com.watayouxiang.myandroid.handler._Handler;
import com.watayouxiang.myandroid.others._Others;
import com.watayouxiang.myandroid.service._Service;
import com.watayouxiang.myandroid.view._View;
import com.watayouxiang.mycommon.Const;

public class _MyAndroid extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addWeb(this, "「view code」", Const.myAndroid_url)
                .addActivity(this, _Activity.class)
                .addActivity(this, _Animation.class)
                .addActivity(this, _Handler.class)
                .addActivity(this, _Others.class)
                .addActivity(this, _Service.class)
                .addActivity(this, _View.class)
                ;
    }
}
