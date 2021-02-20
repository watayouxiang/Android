package com.watayouxiang.myandroid.view;

import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;
import com.watayouxiang.mycommon.Const;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/02/19
 *     desc   :
 * </pre>
 */
public class _View_ extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()

                .addSection("Canvas")
                .addActivity(this, Canvas_BaseActivity.class)
                .addWeb(this, "查看代码", Const.myAndroid_view_url + "Canvas_Base.java")

                .addSection("Path")
                .addActivity(this, Path_BaseActivity.class)
                .addWeb(this, "查看代码", Const.myAndroid_view_url + "Path_Base.java")

                .addSection("View基础")
                .addActivity(this, View_Base01Activity.class)
                .addWeb(this, "查看代码", Const.myAndroid_view_url + "View_Base01.java")

                ;
    }
}

