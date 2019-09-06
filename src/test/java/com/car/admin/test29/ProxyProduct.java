package com.car.admin.test29;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-30 21:36
 **/
public class ProxyProduct implements IProduct{

    private IProductImpl product;

    public ProxyProduct(IProductImpl product){
       this.product = product;
    }

    @Override
    public void getProductInfo() {
        System.out.println("方法执行前");
        product.getProductInfo();
        System.out.println("方法执行后");
    }
}
