package com.watayouxiang.androidcode.handler;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

public class Handler_runOnUIThread implements View.OnClickListener {
    @Override
    public void onClick(final View v) {
        final Activity activity = getActivity(v);
        if (activity == null) return;

        //用Activity对象的runOnUiThread方法
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, "activity.runOnUiThread(Runnable r)", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Activity getActivity(View v) {
        if (v.getContext() instanceof Activity) {
            return (Activity) v.getContext();
        }
        return null;
    }
}
