package com.watayouxiang.androidcode.others;

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
public class _Others extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addWeb(this, "「view code」", Const.others_url)
                .addWeb(this, Const.others_url + "/Android内存泄漏.md")
                .addWeb(this, Const.others_url + "/Android架构.md")
                ;
    }
}
