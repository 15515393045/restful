package com.car.admin.test42;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-10-07 22:11
 **/
public class Demo {
    public static void main(String[] args) {
        Fu fu = new Zi();
        //fu.Fu();

        Zi zi = (Zi) fu;
        boolean b = zi instanceof Fu;
        if(b){
            zi.Zi();
        }
    }
}
