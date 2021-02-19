package com.watayouxiang.androidcode.activity;

import com.watayouxiang.androidcode.Const;
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
public class _Activity extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addWeb(this, "view code", Const.activity_url)
                .addWeb(this, Const.activity_url + "/启动模式.txt")
                .addWeb(this, Const.activity_url + "/生命周期.txt")
                ;
    }
}
