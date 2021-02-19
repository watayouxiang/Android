package com.watayouxiang.androidcode.handler;

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
public class _Handler extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addWeb(this, "view code", Const.handler_dir)
                .addClick(new Handler_basicUse())
                .addClick(new Handler_basicUse2())
                .addClick(new Handler_runOnUIThread())
                .addClick(new Handler_post())
                .addClick(new Handler_showToastOnThread())
                .addClick(new HandlerThread_basicUse())
                .addClick(new HandlerThread_basicUse2())
                .addWeb(this, Const.handler_dir + "/HandlerThread介绍.md")
                .addWeb(this, Const.handler_dir + "/Handler介绍.md")
                ;
    }
}
