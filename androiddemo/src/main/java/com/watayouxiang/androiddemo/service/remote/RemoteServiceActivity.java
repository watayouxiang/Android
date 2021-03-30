package com.watayouxiang.androiddemo.service.remote;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import com.watayouxiang.androiddemo.service.LogUtil;
import com.watayouxiang.demoshell.ListActivity;
import com.watayouxiang.demoshell.ListData;
import com.watayouxiang.remoteservice.RemoteServiceApi;

public class RemoteServiceActivity extends ListActivity {
    private Intent intent;
    private RemoteServiceConnection connection;
    private RemoteServiceApi remoteService;

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        intent = new Intent();
        //为了防止多个Service用同样intent-filter情况
        intent.setPackage("com.watayouxiang.remoteservice");
        intent.setAction("com.watayouxiang.remoteservice.action");
        connection = new RemoteServiceConnection();
    }

    @Override
    protected ListData getListData() {
        return new ListData()
                .addSection("TAG: LogUtil")

                .addSection("启动远程服务")
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

                .addSection("绑定远程服务")
                .addClick("bindService", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bindService(intent, connection, BIND_AUTO_CREATE);
                    }
                })
                .addClick("调用远程服务-sayHi", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (remoteService != null) {
                            try {
                                remoteService.sayHi();
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                })
                .addClick("调用远程服务-openServiceApp", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (remoteService != null) {
                            try {
                                remoteService.openServiceApp();
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
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

    private class RemoteServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LogUtil.d("onServiceConnected");
            remoteService = RemoteServiceApi.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            LogUtil.d("onServiceDisconnected");
            remoteService = null;
        }
    }
}
