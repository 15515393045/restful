package com.car.admin.test18;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-22 16:02
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class httpClientTest {

    @Test
    public void test(){

        CloseableHttpClient build = HttpClientBuilder.create().build();

        HttpGet httpGet = new HttpGet("https://www.baidu.com");

        CloseableHttpResponse execute = null;
        try {
            execute  = build.execute(httpGet);

            HttpEntity entity = execute.getEntity();

            String s = EntityUtils.toString(entity, "UTF-8");

            File file = new File("D:/baidu.html");

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(s);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(execute!=null){
                    execute.close();
                    execute=null;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
