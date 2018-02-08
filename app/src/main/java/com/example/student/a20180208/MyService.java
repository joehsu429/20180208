package com.example.student.a20180208;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

            Log.d("Myservice", "This is onCreate");


    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("My", "This is onStartCommand");
        new Thread() {
            @Override
            public void run() {
                super.run();
                int i;
                for (i = 0; i < 20; i++)
                {
                    try {
                        Thread.sleep(1000);
                        Log.d("My", "This is onStartCommand"+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();
        return super.onStartCommand(intent, flags, startId);
    }

        @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
