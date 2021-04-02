package com.watayouxiang.androiddemo.handler;

import com.imooc.router.annotations.Destination;
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
@Destination(
        url = "router://page-handler",
        description = "handler测试页"
)
public class HandlerDemoActivity extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addClick(new Handler_basicUse())
                .addClick(new Handler_basicUse2())
                .addClick(new Handler_runOnUIThread())
                .addClick(new Handler_post())
                .addClick(new Handler_showToastOnThread())
                .addClick(new HandlerThread_basicUse())
                .addClick(new HandlerThread_basicUse2())
                ;
    }
}
