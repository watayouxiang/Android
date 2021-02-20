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
                .addWeb(this, "「github homepage」", Const.github_url)

                .addSection("Android")
                .addWeb(this, Const.myAndroid_md_url)
                .addActivity(this, _MyAndroid_.class)

                .addSection("Java")
                .addWeb(this, Const.myJava_md_url)

                .addSection("Document")
                .addWeb(this, Const.myDocument_md_url)

                ;
    }
}
