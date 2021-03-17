package com.car.admin.test80;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 07:07
 **/
public class WithMutiThread {

    public static void main(String[] args) {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        //创建List集合
        List<Callable<String>> list = new ArrayList<>();

        try {
            long startTIme = System.currentTimeMillis();
            //Callable 获取线程的返回值
            Callable<String> callableA = ()->{Thread.sleep(100L);return "A";};
            list.add(callableA);

            Callable<String> callableB = ()->{Thread.sleep(200L);return "B";};
            list.add(callableB);

            Callable<String> callableC = ()->{Thread.sleep(150L);return "C";};
            list.add(callableC);

            Callable<String> callableD = ()->{Thread.sleep(300L);return "D";};
            list.add(callableD);

            List<Future<String>> futures = executorService.invokeAll(list);
            StringBuffer stringBuffer = new StringBuffer();

            for (Future<String> future : futures) {
                stringBuffer.append(future.get());
            }

            long entTime = System.currentTimeMillis();

            System.out.println("四个模拟接口调用完毕。组合结果返回："+stringBuffer.toString()+",总共耗时："+(entTime-startTIme)+"毫秒");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();//关闭线程池
        }

    }




}
