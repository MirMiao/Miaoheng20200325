package com.bw.miaoheng20200325;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 时间 :2020/3/27  13:40
 * 作者 :苗恒
 * 功能 :
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);//初始化Fresco
    }
}
