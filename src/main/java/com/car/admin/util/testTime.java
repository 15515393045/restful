package com.car.admin.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
@Component
public class testTime{

    private static final SimpleDateFormat Time = new SimpleDateFormat("HH:mm:ss");

    //每隔3秒执行一次
    //@Scheduled(fixedRate = 3000)
    public void testTime(){
        System.out.println(Thread.currentThread().getName() +"===="+ Time.format(new Date()));
    }

    //@Scheduled(fixedRate = 2000)
    public void fixedRateTask() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("执行 fixedRate 任务的时间：" + Time.format(new Date()));
    }



}
