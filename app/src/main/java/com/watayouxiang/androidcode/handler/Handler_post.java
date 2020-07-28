package com.watayouxiang.androidcode.handler;

import android.view.View;
import android.widget.Toast;

public class Handler_post implements View.OnClickListener {
    @Override
    public void onClick(final View v) {
        v.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(v.getContext(), "view.post(Runnable r)", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
