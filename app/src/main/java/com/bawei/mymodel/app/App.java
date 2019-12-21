package com.bawei.mymodel.app;

import android.app.Application;
import android.content.Context;

import com.bawei.mymodel.utils.MyCrashHandle;

public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        MyCrashHandle myCrashHandle = new MyCrashHandle();
        Thread.setDefaultUncaughtExceptionHandler(myCrashHandle);
    }

    public static Context getContext() {
        return context;
    }
}
