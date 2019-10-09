package com.car.admin.test69;

/**
 * @program: demo-restful
 * @description: 盘子
 * @author: zhanyh
 * @create: 2019-10-09 13:46
 **/
public class Plate<T> {

    private T item;

    Plate(T item){
        this.item = item;
    }

    public void set(T item){
        this.item = item;
    }

    public T get(){
        return item;
    }

}
