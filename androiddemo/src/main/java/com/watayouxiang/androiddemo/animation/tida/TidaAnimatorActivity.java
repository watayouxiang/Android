package com.watayouxiang.androiddemo.animation.tida;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.watayouxiang.androiddemo.R;
import com.watayouxiang.demoshell.DemoActivity;
import com.watayouxiang.demoshell.ListData;

public class TidaAnimatorActivity extends DemoActivity {
    @Override
    protected CharSequence getPageTitle() {
        return "消息提醒动画";
    }

    @Override
    protected int getHolderViewId() {
        return R.layout.activity_animation_common;
    }

    private TidaAnimator tidaAnimator;

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        ConstraintLayout cl_container = findViewById(R.id.cl_container);
        ViewGroup.LayoutParams params = cl_container.getLayoutParams();
        params.height = getWindowManager().getDefaultDisplay().getHeight() / 2;

        ImageView iv_icon = findViewById(R.id.iv_icon);
        tidaAnimator = new TidaAnimator(iv_icon);
    }

    @Override
    protected ListData getListData() {
        return new ListData()
                .addClick("start", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tidaAnimator.start();
                    }
                })
                .addClick("cancel", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tidaAnimator.cancel();
                    }
                })
                .addClick("release", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tidaAnimator.release();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tidaAnimator.release();
    }
}
