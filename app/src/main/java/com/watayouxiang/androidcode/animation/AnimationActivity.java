package com.watayouxiang.androidcode.animation;

import android.os.Bundle;
import android.view.animation.*;
import android.widget.ImageView;
import com.watayouxiang.androidcode.R;
import com.watayouxiang.demoshell.BaseActivity;

public class AnimationActivity extends BaseActivity {

    private AnimationSet mAnimationSet;

    @Override
    protected int getRootViewId() {
        return R.layout.activity_animation_common;
    }

    @Override
    protected CharSequence getPageTitle() {
        return "补间动画";
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        ImageView iv_icon = findViewById(R.id.iv_icon);

        // 位移动画
//        TranslateAnimation translateAnimation = new TranslateAnimation(10, 100, 20, 170);
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -0.5f,
                Animation.RELATIVE_TO_PARENT, 0.5f,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);

        // 缩放动画
//        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 2, 1, 3);
//        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 2, 2, 0.5f, iv.getWidth() / 2, iv.getHeight() / 2);
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                0.5f, 2f,
                0.5f, 2f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        // 透明度动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 0.9f);

        // 旋转动画
//        RotateAnimation rotateAnimation = new RotateAnimation(10, 180);
//        RotateAnimation rotateAnimation = new RotateAnimation(10, 360, iv.getWidth() / 2, iv.getHeight() / 2);
        RotateAnimation rotateAnimation = new RotateAnimation(
                10, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        Animation[] arr = {translateAnimation, scaleAnimation, alphaAnimation, rotateAnimation};
        for (Animation animation : arr) {
            animation.setDuration(2000);
            // 设置播放重复次数
            animation.setRepeatCount(Animation.INFINITE);
            // 设置重复的模式
            animation.setRepeatMode(Animation.REVERSE);
            // 填充动画结束时的位置
            animation.setFillAfter(true);
        }

        mAnimationSet = new AnimationSet(false);
        for (Animation animation : arr) {
            mAnimationSet.addAnimation(animation);
        }
        iv_icon.startAnimation(mAnimationSet);
    }

    @Override
    protected void onDestroy() {
        mAnimationSet.cancel();
        super.onDestroy();
    }
}
