package com.watayouxiang.myandroid.animation;

import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;
import com.watayouxiang.myandroid.animation.tida.TidaAnimatorActivity;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/02/19
 *     desc   :
 * </pre>
 */
public class _Animation_ extends ListActivity {
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