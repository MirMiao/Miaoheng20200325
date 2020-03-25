package com.bw.miaoheng20200325.util;

import com.bw.miaoheng20200325.api.Api;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 时间 :2020/3/25  13:47
 * 作者 :苗恒
 * 功能 :
 */
public class RetfofitUtil {
    private static RetfofitUtil retfofitUtil=new RetfofitUtil();
    private final Retrofit retrofit;

    private RetfofitUtil() {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))//
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RetfofitUtil getInstance() {
        return retfofitUtil;
    }
    public <T>T creatService(Class<T> tClass){
        return retrofit.create(tClass);
    }
}
