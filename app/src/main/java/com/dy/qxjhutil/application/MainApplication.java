package com.dy.qxjhutil.application;

import android.app.Application;

import com.tencent.bugly.Bugly;

import io.realm.Realm;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Bugly.init(getApplicationContext(), "e3d8b35bba", false);

        Realm.init(this);
    }


}
