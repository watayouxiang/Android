package com.watayouxiang.androiddemo.service;

import com.watayouxiang.androiddemo.service.intent.IntentServiceActivity;
import com.watayouxiang.androiddemo.service.local.LocalServiceActivity;
import com.watayouxiang.androiddemo.service.remote.RemoteServiceActivity;
import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/02/19
 *     desc   :
 * </pre>
 */
public class ServiceDemoActivity extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addActivity(this, IntentServiceActivity.class)
                .addActivity(this, LocalServiceActivity.class)
                .addActivity(this, RemoteServiceActivity.class)
                ;
    }
}
