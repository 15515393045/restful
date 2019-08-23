package com.car.admin.test21;

import com.car.admin.util.MD5Util;
import com.qcloud.cos.utils.Md5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-22 21:02
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class InterfaceSafety {

    private String appKey = "zhanyiheng";

    private String appSecret = "zhanyiheng1018";

    private Long currentTime = new Date().getTime();

    private String nonce = getRandStr(6);

    //生成随机数
    public static String getRandStr(int length){
        Random rand = new Random();
        String str = "";
        for(int i=0 ;i<length;i++){
            str +=rand.nextInt(9);
        }
        return  str;
    }

    private String signCheckSum = appKey+appSecret+currentTime+nonce;



    @Test
    public void test(){
        String md5Sign = MD5Util.getStringMD5(signCheckSum);

        System.out.println("客户端当前时间戳："+currentTime);

        System.out.println("随机数："+nonce);

        System.out.println("签名值："+md5Sign);
    }

}
