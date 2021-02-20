package com.watayouxiang.myandroid.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

import com.nineoldandroids.view.ViewHelper;

import java.util.Locale;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2/19/21
 *     desc   : 
 * </pre>
 */
public class View_Base01 extends TextView {
    private static final String TAG = "TestButton";

    public View_Base01(Context context) {
        super(context);
        init();
    }

    public View_Base01(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public View_Base01(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        // 系统能识别的最小滑动距离
        int mScaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        Log.d(TAG, "scaledTouchSlop:" + mScaledTouchSlop);
    }

    // 分别记录上次滑动的坐标
    private int mLastX = 0;
    private int mLastY = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();

        switch (event.getAction()) {
            // 手指刚接触屏幕
            case MotionEvent.ACTION_DOWN: {
                printViewInfo();
                break;
            }
            // 手指在屏幕上移动
            case MotionEvent.ACTION_MOVE: {
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                Log.d(TAG, "move, deltaX:" + deltaX + " deltaY:" + deltaY);

                // 获取 translationX、translationY
                int translationX = (int) ViewHelper.getTranslationX(this) + deltaX;
                int translationY = (int) ViewHelper.getTranslationY(this) + deltaY;
                // 修改 translationX、translationY
                ViewHelper.setTranslationX(this, translationX);
                ViewHelper.setTranslationY(this, translationY);
                break;
            }
            // 手指从屏幕上松开的一瞬间
            case MotionEvent.ACTION_UP: {
                break;
            }
            default:
                break;
        }

        mLastX = x;
        mLastY = y;
        return true;
    }

    private void printViewInfo() {
        // 左上角横坐标
        int left = getLeft();
        // 右下角横坐标
        int right = getRight();
        // 左上角纵坐标
        int top = getTop();
        // 右下角做坐标
        int bottom = getBottom();
        Log.d(TAG, String.format(Locale.getDefault(),
                "left = %d, right = %d, top = %d, bottom = %d",
                left, right, top, bottom));

        // android3.0新增
        // 左上角坐标
        int x = (int) getX();
        int y = (int) getY();
        // 左上角相对于父容器的偏移量
        int translationX = (int) getTranslationX();
        int translationY = (int) getTranslationY();
        Log.d(TAG, String.format(Locale.getDefault(),
                "x = %d, y = %d, translationX = %d, translationY = %d",
                x, y, translationX, translationY));

        // 兼容老版本
        int translationX1 = (int) ViewHelper.getTranslationX(this);
        int translationY1 = (int) ViewHelper.getTranslationY(this);
        Log.d(TAG, String.format(Locale.getDefault(),
                "translationX1 = %d, translationY1 = %d",
                translationX1, translationY1));
    }

}
