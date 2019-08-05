package com.car.admin.test10;

import com.car.admin.util.MD5Util;
import sun.security.provider.MD5;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-05 11:34
 **/
public class DemoMD5 {

    public static void main(String[] args) {
        String stringMD5 = MD5Util.getStringMD5("123456");
        System.out.println(stringMD5);
    }

}
