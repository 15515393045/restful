package com.car.admin.test15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-19 08:41
 **/
public class ThreadDome {


    private static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor
            //线程池的核心大小4;线程池的最大值;队列;存活时间1秒,及非核心线程外的线程
            (4,8,1,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());

    public static void main(String[] args) {
        //调用执行方法
        //使用Jdk1.8新特性 ()相对于run方法，{}run方法中的具体方法。
        poolExecutor.execute(()->{
            for (int i = 0; i < 50; i++) {
                File file = new File("d:/ThreadTest/" + UUID.randomUUID().toString().toUpperCase() + ".txt");
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file);
                    fileWriter.write("测试");
                    fileWriter.flush();
                    //设置休眠时间
                    Thread.sleep(1000);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (null != fileWriter) {
                        try {
                            fileWriter.close();
                            fileWriter = null;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}



