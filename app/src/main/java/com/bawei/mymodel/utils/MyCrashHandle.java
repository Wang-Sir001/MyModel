package com.bawei.mymodel.utils;

import android.util.Log;

import androidx.annotation.NonNull;

public class MyCrashHandle implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        Log.e("error====",e.getMessage());
    }
}
