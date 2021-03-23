package com.watayouxiang.myandroid.service.intent_service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;

public class IntentServiceActivity extends ListActivity {

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
    }

    @Override
    protected ListData getListData() {
        return new ListData()
                .addSection("TAG: LogUtil")
                .addSection("启动 IntentService")
                .addClick("startService", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(IntentServiceActivity.this, MyIntentService.class);
                        intent.putExtra(MyIntentService.KEY_DATA, "Bundle数据");
                        startService(intent);
                    }
                });
    }
}
