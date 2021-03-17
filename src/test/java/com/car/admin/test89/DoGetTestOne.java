package com.car.admin.test89;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;



/**
 * @program: demo-restful
 * @description: 关联login项目
 * @author: zhanyh
 * @create: 2020-05-30 20:05
 **/
public class DoGetTestOne {


public static void main(String[] args) {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet get = new HttpGet("http://localhost:8080/Test/doGetControllerOne");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(get);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity  = response.getEntity();

            System.out.println("响应状态为："+response.getStatusLine());
            if(responseEntity!=null){
                System.out.println("响应内容长度为："+responseEntity.getContentLength());
                System.out.println("响应内容类型为："+responseEntity.getContentType());
                //使用EntityUtils将其转换为字符串
                System.out.println("响应内容为："+EntityUtils.toString(responseEntity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
                try {
                    //关闭响应
                    if(response!=null) {
                        response.close();
                    }
                    //关闭连接
                    if(httpClient!=null){
                        httpClient.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }


}
