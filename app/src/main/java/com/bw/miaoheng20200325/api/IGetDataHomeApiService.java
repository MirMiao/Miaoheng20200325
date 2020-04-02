package com.bw.miaoheng20200325.api;

import com.bw.miaoheng20200325.entity.HomeDataEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 时间 :2020/4/1  13:43
 * 作者 :苗恒
 * 功能 :
 */
public interface IGetDataHomeApiService {
    @GET("small/commodity/v1/commodityList")
    Observable<HomeDataEntity> getHomeData();
}
