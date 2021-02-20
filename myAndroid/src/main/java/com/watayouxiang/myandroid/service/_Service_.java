package com.watayouxiang.myandroid.service;

import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;
import com.watayouxiang.myandroid.service.intent_service.IntentServiceActivity;
import com.watayouxiang.myandroid.service.local_service.LocalServiceActivity;
import com.watayouxiang.myandroid.service.remote_service.RemoteServiceActivity;
import com.watayouxiang.mycommon.Const;

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

                .addSection("IntentService")
                .addActivity(this, IntentServiceActivity.class)
                .addWeb(this, "查看代码", Const.myAndroid_service_url + "intent_service")

                .addSection("LocalService")
                .addActivity(this, LocalServiceActivity.class)
                .addWeb(this, "查看代码", Const.myAndroid_service_url + "local_service")

                .addSection("RemoteService")
                .addActivity(this, RemoteServiceActivity.class)
                .addWeb(this, "查看代码", Const.myAndroid_service_url + "remote_service")
                .addWeb(this, "remoteService", Const.remoteService_url)
                ;
    }
}
