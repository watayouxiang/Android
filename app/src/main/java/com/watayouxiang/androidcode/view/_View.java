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
                .addWeb(this, Const.view_url)
                .addSection("Canvas, Path")
                .addActivity(this, i01Activity.class)
                .addSection("view 事件体系")
                .addActivity(this, i02Activity.class)
                ;
    }
}

