package com.car.admin.test11;

import sun.misc.BASE64Encoder;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-05 13:59
 **/
public class DemoBASE64 {

    public static void main(String[] args) {
        //加密
        String name = "zhanyiheng";

        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode = base64Encoder.encode(name.getBytes());

        System.out.println(encode);
        //输出结果：emhhbnlpaGVuZw==
    }

}
