package com.bw.miaoheng20200325;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 时间 :2020/4/2  14:09
 * 作者 :苗恒
 * 功能 :
 */
 @Entity
public class Province {
    String province; //省
    String city;//市
    String country;//县
    @Generated(hash = 1462390253)
    public Province(String province, String city, String country) {
        this.province = province;
        this.city = city;
        this.country = country;
    }
    @Generated(hash = 1309009906)
    public Province() {
    }
    public String getProvince() {
        return this.province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return this.country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

}
