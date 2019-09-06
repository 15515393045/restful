package com.car.admin.test29;

import org.springframework.stereotype.Service;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 21:35
 **/
public class IProductImpl implements IProduct {

    @Override
    public void getProductInfo() {
        System.out.println("这里是商品");
    }

}
