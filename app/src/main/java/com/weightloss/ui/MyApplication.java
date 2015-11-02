package com.weightloss.ui;

import android.app.Application;

/**
 * Created by admin on 2015/11/2.
 */
public class MyApplication extends Application {

    private static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance(){
        return instance;
    }
}
