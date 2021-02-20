package com.watayouxiang.myandroid.activity;

import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;
import com.watayouxiang.myandroid.MDProducer;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/02/19
 *     desc   :
 * </pre>
 */
public class _Activity extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addWeb(this, "「view code」", MDProducer.Const.activity_url)
                .addWeb(this, MDProducer.Const.activity_url + "/启动模式.txt")
                .addWeb(this, MDProducer.Const.activity_url + "/生命周期.txt")
                ;
    }
}
