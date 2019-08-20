package com.car.admin;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CarBean implements Serializable {

    private static final long serialVersionUID = -7409990103351721134L;

    @SerializedName("名字")
    private String carName;
    @SerializedName("价格")
    private Float carPrice;

    //无参构造函数
    CarBean(){}



    //有参构造函数
    public CarBean(String carName,float carPrice){
        this.carName = carName;
        this.carPrice = carPrice;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Float getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Float carPrice) {
        this.carPrice = carPrice;
    }



}
