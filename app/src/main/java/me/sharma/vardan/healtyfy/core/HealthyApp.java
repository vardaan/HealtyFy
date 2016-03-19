package me.sharma.vardan.healtyfy.core;

import android.app.Application;

public class HealthyApp extends Application {
    private static HealthyApp instance;

    public static HealthyApp getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}