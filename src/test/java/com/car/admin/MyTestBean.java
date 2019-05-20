package com.car.admin;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MyTestBean {

    private String testStr = "张三";

    public String getTestStr(){
        return testStr;
    }

    public void setTestStr(String testStr){
        this.testStr = testStr;
    }


    public static void main(String[] args) {

/*        int[] arr = {1,2,3,4,5};

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                    if(arr[j] < arr[j+1]){
                        int a = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j+1] = a;
                    }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //打开浏览器
        CloseableHttpClient build = HttpClientBuilder.create().build();
        //输入网址
        HttpGet httpGet = new HttpGet("https://www.baidu.com/");

        CloseableHttpResponse execute = null;
        FileWriter writer = null;
        try {
            //发送请求
            execute = build.execute(httpGet);
            //Entity实体 获取实体
            HttpEntity entity = execute.getEntity();
            //通过第三方工具包EntityUtils进行内容转换
            String string = EntityUtils.toString(entity, "utf-8");
            //输出网址内容
            System.out.println(string);
            //下载文件
            writer = new FileWriter("d:/baidu.html");
            writer.write(string);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer != null){
                try {
                    writer.close();
                    writer = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }     if(execute!=null){
                try {
                    //关闭响应
                    execute.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpGet!=null){
                //关闭连接
                httpGet.releaseConnection();
            }
            if(build!=null){
                try {
                    //关闭浏览器
                    build.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
*/

        HashMap map = new HashMap();
        map.put("name","张三");
        map.put("age",15);
        map.put("sex","男");
        List<String> list = new ArrayList<>();
        list.add("三国");
        list.add("西游");
        list.add("水浒");
        map.put("bookList",list);

        //方法一：对所有的键值对进行循环遍历
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry next = (Map.Entry)iterator.next();
            System.out.println(next.getKey()+"=="+next.getValue());
        }

        //方法二：通过keySet,key的集合key为字符串
        Iterator iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()){
            String key = (String) iterator1.next();
            System.out.println(key+"=="+map.get(key));
        }

    }
}
