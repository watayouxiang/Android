package com.watayouxiang.androidcode.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;

public class TidaAnimator {
    private View view;
    private ObjectAnimator animator;
    private boolean start = false;

    public TidaAnimator(View view) {
        this.view = view;
    }

    private ObjectAnimator getAnimator(final View view) {
        if (view == null) return null;
        if (animator == null) {
            //踢跶动画
            PropertyValuesHolder scaleX = PropertyValuesHolder.ofKeyframe(View.SCALE_X,
                    Keyframe.ofFloat(0f, 1f),
                    Keyframe.ofFloat(.1f, .9f),
                    Keyframe.ofFloat(.2f, .9f),
                    Keyframe.ofFloat(.3f, 1.1f),
                    Keyframe.ofFloat(.4f, 1.1f),
                    Keyframe.ofFloat(.5f, 1.1f),
                    Keyframe.ofFloat(.6f, 1.1f),
                    Keyframe.ofFloat(.7f, 1.1f),
                    Keyframe.ofFloat(.8f, 1.1f),
                    Keyframe.ofFloat(.9f, 1.1f),
                    Keyframe.ofFloat(1f, 1f)
            );
            PropertyValuesHolder scaleY = PropertyValuesHolder.ofKeyframe(View.SCALE_Y,
                    Keyframe.ofFloat(0f, 1f),
                    Keyframe.ofFloat(.1f, .9f),
                    Keyframe.ofFloat(.2f, .9f),
                    Keyframe.ofFloat(.3f, 1.1f),
                    Keyframe.ofFloat(.4f, 1.1f),
                    Keyframe.ofFloat(.5f, 1.1f),
                    Keyframe.ofFloat(.6f, 1.1f),
                    Keyframe.ofFloat(.7f, 1.1f),
                    Keyframe.ofFloat(.8f, 1.1f),
                    Keyframe.ofFloat(.9f, 1.1f),
                    Keyframe.ofFloat(1f, 1f)
            );
            float shakeFactor = 1f;
            PropertyValuesHolder rotate = PropertyValuesHolder.ofKeyframe(View.ROTATION,
                    Keyframe.ofFloat(0f, 0f),
                    Keyframe.ofFloat(.1f, -3f * shakeFactor),
                    Keyframe.ofFloat(.2f, -3f * shakeFactor),
                    Keyframe.ofFloat(.3f, 3f * shakeFactor),
                    Keyframe.ofFloat(.4f, -3f * shakeFactor),
                    Keyframe.ofFloat(.5f, 3f * shakeFactor),
                    Keyframe.ofFloat(.6f, -3f * shakeFactor),
                    Keyframe.ofFloat(.7f, 3f * shakeFactor),
                    Keyframe.ofFloat(.8f, -3f * shakeFactor),
                    Keyframe.ofFloat(.9f, 3f * shakeFactor),
                    Keyframe.ofFloat(1f, 0)
            );
            animator = ObjectAnimator.ofPropertyValuesHolder(view, scaleX, scaleY, rotate);
            animator.setDuration(1000);
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    view.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (start) {
                                animator.start();
                            }
                        }
                    }, 3000);
                }
            });
        }
        return animator;
    }

    public void start() {
        if (start) return;
        ObjectAnimator animator = getAnimator(view);
        if (animator == null) return;
        start = true;
        animator.start();
    }

    public void cancel() {
        if (animator == null) return;
        if (!start) return;
        start = false;
    }

    public void release() {
        start = false;
        if (animator != null) {
            animator = null;
        }
        if (view != null) {
            view = null;
        }
    }
}
