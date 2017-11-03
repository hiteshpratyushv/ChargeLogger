package com.charge.chargelogger;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    int count=10,flag;
    Intent i;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        flag=1;
        i=intent;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        flag=0;

    }
}
