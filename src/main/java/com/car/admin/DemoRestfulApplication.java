package com.car.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.car.admin.mapper")
//启用定时任务功能
//@EnableScheduling
@EnableTransactionManagement//开启事务
public class DemoRestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRestfulApplication.class, args);
    }

    //定时任务线程池
    @Bean
    public TaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        //线程池大小
        scheduler.setPoolSize(10);
        //线程名的前缀
        scheduler.setThreadNamePrefix("test");
        return scheduler;
    }

}
