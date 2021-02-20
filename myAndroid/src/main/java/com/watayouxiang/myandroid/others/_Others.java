package com.watayouxiang.myandroid.others;

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
public class _Others extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addWeb(this, "「view code」", Const.myAndroid_others_url)
                .addWeb(this, Const.myAndroid_others_url + "/Android内存泄漏.md")
                .addWeb(this, Const.myAndroid_others_url + "/Android架构.md")
                ;
    }
}
