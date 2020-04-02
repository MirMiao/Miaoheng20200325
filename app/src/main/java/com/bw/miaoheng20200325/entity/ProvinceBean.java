package com.bw.miaoheng20200325.entity;

/**
 * 时间 :2020/4/2  13:46
 * 作者 :苗恒
 * 功能 :
 */
public class ProvinceBean {
    private String name;

    public ProvinceBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPickerViewText(){
        return this.name;
    }
}
