package com.watayouxiang.myandroid.service;

import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;
import com.watayouxiang.myandroid.service.intent_service.IntentServiceActivity;
import com.watayouxiang.myandroid.service.local_service.LocalServiceActivity;
import com.watayouxiang.myandroid.service.remote_service.RemoteServiceActivity;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/02/19
 *     desc   :
 * </pre>
 */
public class _Service_ extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addActivity(this, IntentServiceActivity.class)
                .addActivity(this, LocalServiceActivity.class)
                .addActivity(this, RemoteServiceActivity.class)
                ;
    }
}
