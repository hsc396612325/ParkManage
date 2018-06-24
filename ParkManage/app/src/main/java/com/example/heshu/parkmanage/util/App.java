package com.example.heshu.parkmanage.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by heshu on 2018/1/29.
 */

public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }

}
