package com.watayouxiang.androidcode.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;

public class LocalServiceActivity extends ListActivity {
    private Intent intent;
    private MyServiceConnection connection;
    private LocalService.Api serviceInterface;

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        intent = new Intent(LocalServiceActivity.this, LocalService.class);
        connection = new MyServiceConnection();
    }

    @Override
    protected ListData getListData() {
        return new ListData()
                .addSection("TAG: LogUtil")
                .addSection("启动服务")
                .addClick("startService", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startService(intent);
                    }
                })
                .addClick("stopService", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopService(intent);
                    }
                })
                .addSection("绑定服务")
                .addClick("bindService", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bindService(intent, connection, BIND_AUTO_CREATE);
                    }
                })
                .addClick("调用服务", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (serviceInterface != null) {
                            serviceInterface.playMusic();
                        }
                    }
                })
                .addClick("unbindService", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //如果没绑定服务，却调用解绑服务方法，则会包以下错误：
                        //illegalArgumentException: Service not registered
                        unbindService(connection);
                    }
                });
    }

    private class MyServiceConnection implements ServiceConnection {
        /**
         * 服务连接建立时，此方法调用。
         * 绑定服务，其实就是连接到服务。
         * onBind有返回值才会调用
         */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LogUtil.d("onServiceConnected");
            serviceInterface = (LocalService.Api) service;
        }

        /**
         * 失去服务连接时调用
         */
        @Override
        public void onServiceDisconnected(ComponentName name) {
            LogUtil.d("onServiceDisconnected");
            serviceInterface = null;
        }
    }
}
