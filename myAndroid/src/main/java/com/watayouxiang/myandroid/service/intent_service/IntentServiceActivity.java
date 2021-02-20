package com.watayouxiang.myandroid.service.intent_service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;

public class IntentServiceActivity extends ListActivity {
    private Intent intent;

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        intent = new Intent(IntentServiceActivity.this, IntentService.class);
        intent.putExtra("start", "IntentServiceDemo");
    }

    @Override
    protected ListData getListData() {
        return new ListData()
                .addSection("TAG: LogUtil")
                .addSection("启动 IntentService")
                .addClick("startService", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startService(intent);
                    }
                });
    }
}
