package com.bw.miaoheng20200325.api;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.bw.miaoheng20200325.greendao.DaoMaster;
import com.bw.miaoheng20200325.greendao.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 时间 :2020/3/27  13:40
 * 作者 :苗恒
 * 功能 :
 */
public class MyApplication extends Application {
    private static MyApplication mApp;
    private static DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp=this;
        Fresco.initialize(this);//初始化Fresco
        initGreenDao();
    }
    //初始化数据库
    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(mApp, "province.db");
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        mDaoSession = daoMaster.newSession();
    }
    public static DaoSession getDapSession(){
        return mDaoSession;
    }
}
