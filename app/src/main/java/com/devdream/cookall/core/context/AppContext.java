package com.devdream.cookall.core.context;

import android.app.Application;
import android.content.Context;

public class AppContext extends Application {

    public static Context context;

    public void onCreate() {
        super.onCreate();
        AppContext.context = getApplicationContext();
    }

}
