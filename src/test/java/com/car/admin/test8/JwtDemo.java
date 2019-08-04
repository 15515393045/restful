package com.car.admin.test8;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-04 16:20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtDemo {

    //JWT加密
    @Test
    public void test1(){
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("1")//用户ID
                .setSubject("zyh")//JWT所面向的用户
                .setIssuedAt(new Date())//签发时间
                .setExpiration(new Date(System.currentTimeMillis()+120000))//过期时间
                // 加密方式是hs256,盐是zhanyiheng，注意盐的字符不可过少。
                .signWith(SignatureAlgorithm.HS256,"zhanyiheng");//签名值/私钥
        //生成一个字符串用.分为了三个部分第一部分为头部，第二部分为有效载荷，第三部分叫签名值。
        System.out.println(jwtBuilder.compact());
    }

    //JWT解密
    @Test
    public void test2(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwic3ViIjoienloIiwiaWF0IjoxNTY0OTA4Mjg4LCJleHAiOjE1NjQ5MDg0MDh9.vi-PxxhyzcvjDOhCl3m7lWvXL5mNNV6yEpJyZVCmRuo";
        //zhanyiheng是传过来的私钥，盐
        Claims claims = Jwts.parser().setSigningKey("zhanyiheng").parseClaimsJws(token).getBody();

        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(claims.getIssuedAt()));
    }
}
