package com.watayouxiang.myandroid.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.ImageView;

import com.blankj.utilcode.util.ScreenUtils;
import com.watayouxiang.demoshell.BaseActivity;
import com.watayouxiang.myandroid.R;

public class AnimatorActivity extends BaseActivity {

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
        float screenWidth = ScreenUtils.getScreenWidth();

        // 位移动画
        ObjectAnimator translationX = ObjectAnimator.ofFloat(iv_icon, "translationX", -screenWidth / 2, screenWidth / 2);
        // 缩放动画
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(iv_icon, "scaleX", 0.5f, 2f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(iv_icon, "scaleY", 0.5f, 2f);
        // 透明度动画
        ObjectAnimator alpha = ObjectAnimator.ofFloat(iv_icon, "alpha", 0.1f, 0.9f);
        // 旋转动画
        ObjectAnimator rotation = ObjectAnimator.ofFloat(iv_icon, "rotation", 10, 360);

        // 配置动画
        ObjectAnimator[] arr = {translationX, scaleX, scaleY, alpha, rotation};
        for (ObjectAnimator objectAnimator : arr) {
            objectAnimator.setDuration(2000);
            // 设置播放重复次数
            objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
            // 设置重复的模式
            objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        }

        mAnimatorSet = new AnimatorSet();

//        // 顺序播放动画
//        mAnimatorSet.playSequentially(translationX, scaleX, alpha, rotation);
//
//        // 设置改变哪个对象的属性
//        mAnimatorSet.setTarget(iv_icon);
//
//        // with一起播放，after之后播放，before之前播放
//        mAnimatorSet.play(translationX).with(scaleX).after(alpha).before(rotation);

        // 一起播放
        mAnimatorSet.playTogether(arr);

        // 开始播放
        mAnimatorSet.start();
    }

    @Override
    protected void onDestroy() {
        mAnimatorSet.cancel();
        super.onDestroy();
    }
}
