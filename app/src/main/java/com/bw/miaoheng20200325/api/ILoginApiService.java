package com.bw.miaoheng20200325.api;

import com.bw.miaoheng20200325.entity.LoginEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 时间 :2020/3/25  13:50
 * 作者 :苗恒
 * 功能 :
 */
public interface ILoginApiService {
    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<LoginEntity> login(@Field("phone") String phone, @Field("pwd")String pwd);
}
