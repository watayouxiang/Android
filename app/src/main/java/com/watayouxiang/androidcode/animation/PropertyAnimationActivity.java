package com.watayouxiang.androidcode.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.watayouxiang.androidcode.R;
import com.watayouxiang.demoshell.BaseActivity;

/*
animation和animator的用法,概述实现原理

参考：https://blog.csdn.net/weixin_41205419/article/details/85038275

原理：Animation 在 View 内部真实的坐标位置及其他相关属性始终恒定。
    使用 Animator 时，内部的属性发生了变化，方法内部自行调取的类似invalidate的方法。

优劣势：
- Animation 先出现，Animator 后出现。
- Animation 补间动画能做的，Animator 属性动画都能做。
- Animation 适用于 View 对象，但是 Animator 适用于任意对象。
- Animator 使用了反射机制，所以其效率偏低。
- Animator 占用内存比 Animation 大。

 */
public class PropertyAnimationActivity extends BaseActivity {

    private AnimatorSet mAnimatorSet;

    @Override
    protected int getRootViewId() {
        return R.layout.activity_animation_common;
    }

    @Override
    protected CharSequence getPageTitle() {
        return "属性动画";
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        ImageView iv_icon = findViewById(R.id.iv_icon);
        float screenWidth = getScreenWidth(this);

        //位移动画
        ObjectAnimator translationX = ObjectAnimator.ofFloat(iv_icon,
                "translationX", -screenWidth / 2, screenWidth / 2);
        //缩放动画
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(iv_icon,
                "scaleX", 0.5f, 2f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(iv_icon,
                "scaleY", 0.5f, 2f);
        //透明度动画
        ObjectAnimator alpha = ObjectAnimator.ofFloat(iv_icon,
                "alpha", 0.1f, 0.9f);
        //旋转动画
        ObjectAnimator rotation = ObjectAnimator.ofFloat(iv_icon,
                "rotation", 10, 360);

        ObjectAnimator[] arr = {translationX, scaleX, scaleY, alpha, rotation};
        for (ObjectAnimator objectAnimator : arr) {
            objectAnimator.setDuration(2000);
            //设置播放重复次数
            objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
            //设置重复的模式
            objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        }

        mAnimatorSet = new AnimatorSet();
        //顺序播放动画
//        mAnimatorSet.playSequentially(translationX, scaleX, alpha, rotation);
        //一起播放动画
//        mAnimatorSet.playTogether(translationX, scaleX, alpha, rotation);
        //设置改变哪个对象的属性
//        mAnimatorSet.setTarget(iv_icon);
        //with一起播放，after之后播放，before之前播放
//        mAnimatorSet.playMusic(translationX).with(scaleX).after(alpha).before(rotation);
        mAnimatorSet.playTogether(arr);
        mAnimatorSet.start();
    }

    @Override
    protected void onDestroy() {
        mAnimatorSet.cancel();
        super.onDestroy();
    }

    private int getScreenWidth(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }
}
