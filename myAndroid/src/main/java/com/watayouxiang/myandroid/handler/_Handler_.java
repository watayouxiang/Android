package com.watayouxiang.myandroid.handler;

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
public class _Handler_ extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()

                .addSection("基本使用")
                .addClick(new Handler_basicUse())
                .addWeb(this, "查看代码", Const.myAndroid_handler_url + "Handler_basicUse.java")
                .addClick(new Handler_basicUse2())
                .addWeb(this, "查看代码", Const.myAndroid_handler_url + "Handler_basicUse2.java")
                .addClick(new Handler_runOnUIThread())
                .addWeb(this, "查看代码", Const.myAndroid_handler_url + "Handler_runOnUIThread.java")
                .addClick(new Handler_post())
                .addWeb(this, "查看代码", Const.myAndroid_handler_url + "Handler_post.java")

                .addSection("在子线程中弹Toast")
                .addClick(new Handler_showToastOnThread())
                .addWeb(this, "查看代码", Const.myAndroid_handler_url + "Handler_showToastOnThread.java")

                .addSection("HandlerThread")
                .addClick(new HandlerThread_basicUse())
                .addWeb(this, "查看代码", Const.myAndroid_handler_url + "HandlerThread_basicUse.java")
                .addClick(new HandlerThread_basicUse2())
                .addWeb(this, "查看代码", Const.myAndroid_handler_url + "HandlerThread_basicUse2.java")

                .addSection("总结")
                .addWeb(this, Const.myAndroid_handler_url + "/HandlerThread介绍.md")
                .addWeb(this, Const.myAndroid_handler_url + "/Handler介绍.md")

                ;
    }
}
