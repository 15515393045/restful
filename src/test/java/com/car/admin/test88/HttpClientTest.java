package com.car.admin.test88;


import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-30 18:10
 **/
public class HttpClientTest {

    public static void main(String[] args) {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient build = HttpClientBuilder.create().build();
        //创建一个get请求
        //HttpGet get = new HttpGet("http://localhost:8082/user/testFeign");
        //创建一个post请求
        HttpPost post = new HttpPost("http://localhost:8082/user/testFeign");
        //创建一个Map对象并且赋值
        Map<String,Object> map = new HashMap();
        map.put("id",666);
        map.put("shopName","大哥大");
        map.put("price",99.99);
        //将Map对象转换为Json格式的字符串
        String jsonString = JSON.toJSONString(map);
        //指定编码格式
        StringEntity entity = new StringEntity(jsonString,"UTF-8");
        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        post.setEntity(entity);
        //设置请求头信息
        post.setHeader("Content-Type","application/json;charset=utf8");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = build.execute(post);

            // 从响应模型中获取响应实体(获取响应内容)
            HttpEntity responseEntity  = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());

            if(responseEntity != null){
                System.out.println("响应内容长度为："+responseEntity.getContentLength());
                System.out.println("响应内容类型为："+responseEntity.getContentType());
                System.out.println("响应内容编码为："+responseEntity.getContentEncoding());
                //用EntityUtils将其转换为字符串
                System.out.println("响应内容："+EntityUtils.toString(responseEntity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭响应
                if(response!=null){
                    response.close();
                }
                //关闭浏览器
                if(build!=null){
                    build.close();
                }
            } catch (Exception e) {
                //捕捉异常
                System.out.println(e.getMessage());
            }
        }

    }
}




