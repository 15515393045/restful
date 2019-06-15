package com.car.admin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @program: demo-restful
 * @description: 算法
 * @author: zhanyh
 * @create: 2019-06-01 15:26
 **/
public class Demo1 {


    public static void main(String[] args) {


        CarBean bean = new CarBean();
        bean.setCarName("aaa");
        bean.setCarPrice(null);

        GsonBuilder builder = new GsonBuilder();
        String json = builder.serializeNulls().create().toJson(bean);
        System.out.println(json);



    }
}
