package com.car.admin.util;

import com.alibaba.fastjson.JSON;
import com.car.admin.bean.ClientLoginBean;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import sun.misc.BASE64Encoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-06 07:33
 **/
public class JWTUtils {

    public static String JwtUtil(ClientLoginBean user, String scretKey, Long exp){
        Map<String,Object> mapHeader = new HashMap();
        mapHeader.put("typ","JWT");
        mapHeader.put("alg","HS256");

        Map<String,Object> mapPayload = new HashMap();
        mapPayload.put("userID",user.getId());
        mapPayload.put("userName",user.getClientName());
        Long iat = System.currentTimeMillis();
        mapPayload.put("exp",iat+exp);
        mapPayload.put("iat",iat);

        String token = Jwts.builder()
                .setHeader(mapHeader)
                .setPayload(JSON.toJSONString(mapPayload))
                .signWith(SignatureAlgorithm.HS256,getScretKey(scretKey)).compact();

        return token;
    }
    //使用BASE64进行加密
    private static String getScretKey(String ScretKey){
        return new BASE64Encoder().encode(ScretKey.getBytes());
    }
}
