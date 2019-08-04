package com.car.admin.test9;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-04 17:10
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoJWT {

    @Test
    public void test1(){
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("2")
                .setSubject("zhanyh")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+500000))
                .signWith(SignatureAlgorithm.HS256,"hahaha");

         System.out.println(jwtBuilder.compact());
    }

    @Test
    public void test2(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyIiwic3ViIjoiemhhbnloIiwiaWF0IjoxNTY0OTEwMDY5LCJleHAiOjE1NjQ5MTA1Njl9.sV5eMDVTeCfm9YbDKX9NjUw1JDsMI6IWohpUAuZbbQ4";

        Claims claims = Jwts.parser().setSigningKey("hahaha").parseClaimsJws(token).getBody();
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuedAt());
    }

}
