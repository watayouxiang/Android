package com.watayouxiang.androiddemo.animation;

import com.watayouxiang.androiddemo.animation.tida.TidaAnimatorActivity;
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
public class AnimationDemoActivity extends ListActivity {
    @Override
    protected ListData getListData() {
        return new ListData()
                .addActivity(this, AnimationDrawableActivity.class)
                .addActivity(this, AnimationActivity.class)
                .addActivity(this, AnimatorActivity.class)
                .addActivity(this, TidaAnimatorActivity.class)
                ;
    }
}