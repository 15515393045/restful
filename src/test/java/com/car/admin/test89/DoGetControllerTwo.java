package com.car.admin.test89;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-30 20:33
 **/
public class DoGetControllerTwo {
    /**
     * GET---有参测试 (方式一:手动在url后面加上参数)
     */
    public static void main(String[] args) throws IOException {
       CloseableHttpClient httpClient = HttpClientBuilder.create().build();

      /*  拼接参数
        StringBuffer params  = new StringBuffer();
        try {
            // 字符数据最好encoding以下;这样一来，某些特殊字符才能传过去(如:某人的名字就是“&”,不encoding的话,传不过去)
            params.append("name="+URLEncoder.encode("&","UTF-8"));
            params.append("&");
            params.append("age=24");
            System.out.println(params);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/

        //拼接参数
        StringBuffer params = new StringBuffer();
        params.append("name=").append("詹浩辉").append("&").append("age=").append(14);

        //创建Get请求
        HttpGet get = new HttpGet("http://localhost:8080/Test/doGetControllerTwo"+"?"+params);

        // 配置信息
        RequestConfig build = RequestConfig.custom()
                // 设置连接超时时间(单位毫秒)
                .setConnectTimeout(5000)
                // 设置请求超时时间(单位毫秒)
                .setConnectionRequestTimeout(5000)
                // socket读写超时时间(单位毫秒)
                .setSocketTimeout(5000)
                // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(true).build();

        // 将上面的配置信息 运用到这个Get请求里
        get.setConfig(build);

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(get);
            // 从响应模型中获取响应实体
            HttpEntity entity = response.getEntity();
            //通过EntityUtil将其详细的内容转换为字符串
            System.out.println(EntityUtils.toString(entity));

            System.out.println("响应状态为:"+response.getStatusLine());

            if (entity!=null){
                System.out.println("响应内容长度为:"+entity.getContentLength());
                System.out.println("响应内容类型为:"+entity.getContentType());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {// 释放资源
            if(response!=null){
                response.close();
            }
            if(httpClient!=null){
                httpClient.close();
            }
        }

    }
}
