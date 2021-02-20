package com.watayouxiang.androidcode;

import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;
import com.watayouxiang.myandroid._MyAndroid_;
import com.watayouxiang.mycommon.Const;

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
                .addWeb(this, "github homepage", Const.github_url)
                .addActivity(this, _MyAndroid_.class)
                .addWeb(this, "Android", Const.myAndroid_md_url)
                .addWeb(this, "Java", Const.myJava_md_url)
                .addWeb(this, "Document", Const.myDocument_md_url)
                ;
    }
}
