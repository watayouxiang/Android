package com.watayouxiang.myandroid.animation;

import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;
import com.watayouxiang.myandroid.animation.tida.TidaAnimatorActivity;
import com.watayouxiang.mycommon.Const;

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
                .addSection("帧动画")
                .addActivity(this, AnimationDrawableActivity.class)
                .addWeb(this, "查看代码", Const.myAndroid_animation_url + "/AnimationDrawableActivity.java")
                .addSection("补间动画")
                .addActivity(this, AnimationActivity.class)
                .addWeb(this, "查看代码", Const.myAndroid_animation_url + "/AnimationActivity.java")
                .addSection("属性动画")
                .addActivity(this, AnimatorActivity.class)
                .addWeb(this, "查看代码", Const.myAndroid_animation_url + "/AnimatorActivity.java")
                .addSection("消息提醒动画")
                .addActivity(this, TidaAnimatorActivity.class)
                .addWeb(this, "查看代码", Const.myAndroid_animation_url + "/tida")
                .addSection("动画概括")
                .addWeb(this, Const.myAndroid_animation_url + "/动画概括.txt")
                ;
    }
}