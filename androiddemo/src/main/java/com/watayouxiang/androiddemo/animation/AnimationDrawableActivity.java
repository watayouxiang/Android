package com.watayouxiang.androiddemo.animation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.watayouxiang.androiddemo.R;
import com.watayouxiang.demoshell.BaseActivity;

public class AnimationDrawableActivity extends BaseActivity {

    private AnimationDrawable mAnimationDrawable;

    @Override
    protected int getRootViewId() {
        return R.layout.activity_animation_common;
    }

    @Override
    protected CharSequence getPageTitle() {
        return "帧动画";
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        ImageView iv_icon = findViewById(R.id.iv_icon);

        iv_icon.setBackgroundResource(R.drawable.animation_frame);
        Drawable drawable = iv_icon.getBackground();
        if (drawable instanceof AnimationDrawable) {
            mAnimationDrawable = (AnimationDrawable) drawable;
            mAnimationDrawable.start();
        }
    }

    @Override
    protected void onDestroy() {
        if (mAnimationDrawable != null) {
            mAnimationDrawable.stop();
        }
        super.onDestroy();
    }
}
