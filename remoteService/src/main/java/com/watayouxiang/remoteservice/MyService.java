package com.watayouxiang.remoteservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.lang.ref.WeakReference;

public class MyService extends Service {

    private static final int sayHi = 1001;
    private static final int openServiceApp = 1002;

    private final MyHandler handler = new MyHandler(this);

    private static class MyHandler extends Handler {
        private final WeakReference<Context> reference;

        MyHandler(Context context) {
            reference = new WeakReference<>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Context context = reference.get();
            if (context == null) return;
            switch (msg.what) {
                case sayHi:
                    Toast.makeText(context, String.valueOf(msg.obj), Toast.LENGTH_SHORT).show();
                    break;
                case openServiceApp:
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    break;
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.d("远程服务 - onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtil.d("远程服务 - onBind");

        return new RemoteServiceApi.Stub() {
            @Override
            public void sayHi() throws RemoteException {
                LogUtil.d("远程服务 - sayHi");

                Message message = Message.obtain();
                message.what = sayHi;
                message.obj = "hi~~~";
                handler.sendMessage(message);
            }

            @Override
            public void openServiceApp() throws RemoteException {
                LogUtil.d("远程服务 - openServiceApp");

                handler.sendEmptyMessage(openServiceApp);
            }
        };
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("远程服务 - onDestroy");
    }
}
