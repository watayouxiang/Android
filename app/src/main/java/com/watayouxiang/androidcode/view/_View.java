package com.watayouxiang.androidcode.view;

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
public class _View extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addWeb(this, "view code", Const.view_dir)
                .addActivity(this, Test01Activity.class)
                .addActivity(this, Test02Activity.class)
                ;
    }
}

