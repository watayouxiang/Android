package com.watayouxiang.myandroid;

import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;
import com.watayouxiang.myandroid.animation._Animation_;
import com.watayouxiang.myandroid.handler._Handler_;
import com.watayouxiang.myandroid.service._Service_;
import com.watayouxiang.myandroid.view._View_;

public class _MyAndroid_ extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addActivity(this, _Animation_.class)
                .addActivity(this, _Handler_.class)
                .addActivity(this, _Service_.class)
                .addActivity(this, _View_.class)
                ;
    }
}
