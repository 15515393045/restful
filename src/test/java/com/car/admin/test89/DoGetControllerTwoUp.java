package com.car.admin.test89;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-30 20:52
 **/
public class DoGetControllerTwoUp {
    /**
     * GET---有参测试 (方式二:将参数放入键值对类中,再放入URI中,从而通过URI得到HttpGet实例)
     */
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //设置参数
        //将参数放入键值对类NameValuePair(BasicNameValuePair)中,再放入集合中
        List<NameValuePair> list = new ArrayList<>();

        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("name", "詹浩辉");

        list.add(basicNameValuePair);

        list.add(new BasicNameValuePair("age","19"));

        //设置uri路径信息,并将参数集合放入uri;
        URI uri = null;
        try {
            //注:这里也支持一个键值对一个键值对地往里面放setParameter(String key, String value)。
            uri = new URIBuilder()
                    .setScheme("http")
                    .setHost("localhost")
                    .setPort(8080)
                    .setPath("/Test/doGetControllerTwo")
                    .setParameters(list).build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        System.out.println("============================"+uri+"============================");

        //创建Get请求并将设置好的uri放入请求中
        HttpGet get = new HttpGet(uri);

        //设置配置信息
        RequestConfig build = RequestConfig.custom()
                // 设置连接超时时间(单位毫秒)
                .setConnectTimeout(5000)
                // 设置请求超时时间(单位毫秒)
                .setConnectionRequestTimeout(5000)
                // socket读写超时时间(单位毫秒)
                .setSocketTimeout(5000)
                // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(true).build();

        //将设置好的配置信息放入get请求中
        get.setConfig(build);

        //响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(get);
            // 从响应模型中获取响应实体
            HttpEntity entity = response.getEntity();

            System.out.println("响应状态为:"+response.getStatusLine());

            if(entity!=null){
                System.out.println("响应内容为："+EntityUtils.toString(entity));
                System.out.println("响应内容长度为:" + entity.getContentLength());
                System.out.println("响应内容类型为:" + entity.getContentType());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {//释放资源
            if(response!=null){
                response.close();
            }
            if(httpClient!=null){
                httpClient.close();
            }
        }
    }

}
