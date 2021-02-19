package com.watayouxiang.androidcode.animation;

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
public class _Animation extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addWeb(this, "view code", Const.animation_dir)
                .addActivity(this, AnimationDrawableActivity.class)
                .addActivity(this, AnimationActivity.class)
                .addActivity(this, AnimatorActivity.class)
                .addActivity(this, TidaAnimatorActivity.class)
                .addWeb(this, Const.animation_dir + "/动画概括.txt")
                ;
    }
}