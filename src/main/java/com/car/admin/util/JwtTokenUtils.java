package com.car.admin.util;

import com.car.admin.bean.ClientLoginBean;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.sf.json.JSON;
import sun.misc.BASE64Encoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-05 11:53
 **/
public class JwtTokenUtils {

    public static String ToKenUtil(ClientLoginBean user, String secretKey, Long tokenTime){
        //头部
        Map<String,Object> mapHeader = new HashMap<>();
        mapHeader.put("typ","JWT");
        mapHeader.put("alg","HS256");

        //载荷
        Map<String,Object> mapPayLoad = new HashMap<>();
        mapPayLoad.put("userName",user.getClientName());//JWT面向的用户
        mapPayLoad.put("userId",user.getId());//用户ID
        //失效时间等当前系统时间加上过期时间
        Long iat = System.currentTimeMillis();
        mapPayLoad.put("exp",iat + tokenTime);//过期时间/失效时间
        mapPayLoad.put("iat",iat);//签发时间

        //组成字符串token的三个部分
        String token = Jwts.builder()
                //头部
                .setHeader(mapHeader)
                //需要在载荷转换为字符串
                //有效载荷
                .setPayload(com.alibaba.fastjson.JSON.toJSONString(mapPayLoad))
                //签名值   调用BASE64加密方法getSecretKey
                .signWith(SignatureAlgorithm.HS256,getSecretKey(secretKey)).compact();

        return token;
    }
    //BASE64加密
    private static String getSecretKey(String secretKey){
        return new BASE64Encoder().encode(secretKey.getBytes());
    }

}
