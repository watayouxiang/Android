package com.watayouxiang.myandroid.handler;

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
public class _Handler extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addWeb(this, "「view code」", MDProducer.Const.handler_url)
                .addSection("Knowledge Point")
                .addClick(new Handler_basicUse())
                .addClick(new Handler_basicUse2())
                .addClick(new Handler_runOnUIThread())
                .addClick(new Handler_post())
                .addClick(new Handler_showToastOnThread())
                .addClick(new HandlerThread_basicUse())
                .addClick(new HandlerThread_basicUse2())
                .addSection("Summary")
                .addWeb(this, MDProducer.Const.handler_url + "/HandlerThread介绍.md")
                .addWeb(this, MDProducer.Const.handler_url + "/Handler介绍.md")
                ;
    }
}
