package com.dy.qxjhutil.application;

import android.app.Application;

import com.lzf.easyfloat.EasyFloat;
import com.tencent.bugly.Bugly;
import com.xuexiang.xui.XUI;

import io.realm.Realm;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Bugly.init(getApplicationContext(), "06d0ae6d94", false);
//        Bugly.init(getApplicationContext(), "e3d8b35bba", false);

        XUI.init(this); //初始化UI框架
        XUI.debug(true);  //开启UI框架调试日志

        Realm.init(this);
        EasyFloat.init(this);
    }

}
