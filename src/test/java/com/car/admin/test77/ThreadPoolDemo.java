package com.car.admin.test77;

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
 * @create: 2020-05-18 22:07
 **/
public class ThreadPoolDemo {
    //corePoolSize  核心线程数
    //maximumPoolSize 最大线程数
    //keepAliveTime 空闲线程存活时间
    //TimeUnit 时间单位
    //LinkedBlockingQueue 线程池中的队列 LinkedBlockingQueue 无界阻塞队列
  private static  ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor
   (5,10,1,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());


    public static void main(String[] args) {
        //调用方法
        //threadPoolExecutor.execute(new ThreadTest1());
        int corePoolSize = threadPoolExecutor.getCorePoolSize();
        System.out.println("核心线程数："+corePoolSize);
        //()相对于run方法，{}run方法中的具体方法。
        threadPoolExecutor.execute(()->{
            for (int i = 0; i < 50; i++) {
                File file = new File("d:/aaabbb/"+UUID.randomUUID().toString()+".txt");
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file);
                    fileWriter.write("詹一恒");
                    fileWriter.flush();
                    //设置线程的休眠时间 单位毫秒
                    //Thread.sleep(1000);//1秒
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if(fileWriter != null){
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
