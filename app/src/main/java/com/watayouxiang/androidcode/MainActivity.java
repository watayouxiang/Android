package com.watayouxiang.androidcode;

import com.watayouxiang.common.Const;
import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;
import com.watayouxiang.myandroid._MyAndroid;

public class MainActivity extends ListActivity {
    @Override
    protected boolean showBackBtn() {
        return false;
    }

    @Override
    protected CharSequence getPageTitle() {
        return getResources().getString(R.string.app_name);
    }

    @Override
    protected ListData getListData() {
        return new ListData()
                .addWeb(this, "「github homepage」", Const.github_url)
                .addActivity(this, _MyAndroid.class)
                ;
    }
}
