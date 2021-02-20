package com.watayouxiang.myandroid.service;

import com.watayouxiang.common.Const;
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
public class _Service extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addWeb(this, "「view code」", Const.service_url)
                .addSection("Knowledge Point")
                .addActivity(this, IntentServiceActivity.class)
                .addActivity(this, LocalServiceActivity.class)
                .addActivity(this, RemoteServiceActivity.class)
                .addWeb(this, "remoteService", Const.remoteService_url)
                ;
    }
}
