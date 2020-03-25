package com.bw.miaoheng20200325.api;

import com.bw.miaoheng20200325.entity.LoginEntity;
import com.bw.miaoheng20200325.entity.RegEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 时间 :2020/3/25  13:52
 * 作者 :苗恒
 * 功能 :
 */
public interface IRegApiService {
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<RegEntity> reg(@Field("phone") String phone, @Field("pwd")String pwd);
}
