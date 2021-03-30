package com.watayouxiang.androiddemo.view;

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
public class ViewDemoActivity extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addActivity(this, Canvas_BaseActivity.class)
                .addActivity(this, Path_BaseActivity.class)
                .addActivity(this, View_Base01Activity.class)
                ;
    }
}

