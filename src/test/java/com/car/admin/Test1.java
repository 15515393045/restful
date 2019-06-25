package com.car.admin;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.util.Builder;
import org.apache.avalon.framework.activity.Suspendable;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.junit.Test;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.PutMapping;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;

/**
 * @program: demo-restful
 * @description: java8
 * @author: zhanyh
 * @create: 2019-05-31 15:45
 **/
public class Test1 {

    @Test
    public void testPlus(){
        thread.start();
        thread2.start();


    }

    Thread thread = new Thread(new Runnable() {

        public void run() {
            System.out.println("这是个Runable接口实例，用的是匿名内部类");

        }

    });

    Thread thread2 = new Thread(()-> System.out.println("这是个Runable接口实例，用的是Lambda表达式"));


    public static void main(String[] args) throws Exception {

        List<CarBean> carList = new ArrayList();

        CarBean car1 = new CarBean();
        car1.setCarName("宝马");
        car1.setCarPrice((float) 33);

        CarBean car2 = new CarBean();
        car2.setCarName("奔驰");
        car2.setCarPrice((float) 66);

        CarBean car3 = new CarBean();
        car3.setCarName("奥迪");
        car3.setCarPrice((float) 99);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);


/*        for (int i = 0; i < carList.size(); i++) {
            CarBean carBean = carList.get(i);
            System.out.println(carBean.getCarName()+":"+carBean.getCarPrice());
        }*/

        //carList.forEach(x->System.out.println(x.getCarName()+"--"+x.getCarPrice()));

/*        for (int i = 0; i < car.size(); i++) {
            System.out.println(car.get(i));
        }*/
        //lambda循环list
        //car.forEach(x->System.out.println(x));


        Map<String,Object> book = new HashMap<String,Object>();
        book.put("bookName","西游");
        book.put("bookPrice","30");
        book.put("carList",carList);

 /*       Iterator iterator = book.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry next = (Map.Entry) iterator.next();
            System.out.println(next.getKey() +":"+ next.getValue());
        }*/

        //lambda循环map
        // book.forEach((x,y)-> System.out.println(x+"-"+y));

        //静态方法
        //carList.forEach(LambdaTest::show);
        //非静态方法
        // carList.forEach(new LambdaTest()::init);

        //带有返回值的方法一
       /* Callable<List<CarBean>> returnList = LambdaTest::returnList;
        //调用call调用方法并且抛出异常
        List<CarBean> call = returnList.call();
        call.forEach(x->System.out.println(x.getCarName()+":"+x.getCarPrice()));*/

        //带有返回值的方法二
/*        Supplier<List<CarBean>> returnList = LambdaTest::returnList;
        //调用get获取方法
        List<CarBean> carBeans = returnList.get();
        carBeans.forEach(x->System.out.println(x.getCarName()+":"+x.getCarPrice()));*/

        //带有返回值的方法三
        Builder<List<CarBean>> returnList = Test1::returnList;

        //调用build构建方法
        List<CarBean> build = returnList.build();
        build.forEach(x->System.out.println(x.getCarName()+":"+x.getCarPrice()));

    }

    //静态方法
    public static void show(CarBean carBean){
        System.out.println(carBean.getCarName()+"=="+carBean.getCarPrice());
    }

    //非静态方法
    public void init(CarBean carBean){
        System.out.println(carBean.getCarName()+"+++"+carBean.getCarPrice());
    }

    //返回值
    public static List<CarBean> returnList(){
        List<CarBean> carList = new ArrayList();

        CarBean car1 = new CarBean();
        car1.setCarName("宝马");
        car1.setCarPrice((float) 33);

        CarBean car2 = new CarBean();
        car2.setCarName("奔驰");
        car2.setCarPrice((float) 66);

        CarBean car3 = new CarBean();
        car3.setCarName("奥迪");
        car3.setCarPrice((float) 99);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        return carList;
    }

    @Test
    public void testMapAndList(){

        List<String> carList = new ArrayList();
        carList.add("宝马");
        carList.add("奔驰");
        carList.add("奥迪");

        Map<String,List<String>> book = new HashMap<String,List<String>>();
        book.put("carList",carList);

        book.forEach((x,y)->{
            System.out.println(x+":");
            y.forEach(z->System.out.println(z));
        });
    }
    @Test
    public void test6(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        System.out.println(format.format(date));
    }

    @Test
    public void test7() throws IOException {
        //写文件
        FileWriter writer = new FileWriter("D:/zhan.txt");
        writer.write("test");
        writer.flush();
        writer.close();
        //读文件
        File file = new File("D:/zhan.txt");
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        System.out.println(bufferedReader.readLine());
        bufferedReader.close();
        reader.close();
    }


    @Test
    public void test8() throws IOException {
        FileWriter writer = new FileWriter("D:/aaa.txt");
        writer.write("尚东海");
        writer.flush();
        writer.close();

        File file = new File("D:/aaa.txt");
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        System.out.println(bufferedReader.readLine());
        bufferedReader.close();
    }

    @Test
    public void test9(){
        //^
        //System.out.println(15 ^ 5);
        //System.out.println(0 ^ 5);
        //System.out.println(5 ^ 5);

      /*  int i = 2;
        int j = 5;

        i = i ^ j;
        j = i ^ j;
        i = i ^ j;
        System.out.println(i);
        System.out.println(j+"aa");*/

      int[] arr = {2,1,5,3,4};

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                    if(arr[j] > arr[j+1]){
                        arr[j] = arr[j] ^ arr[j+1];
                        arr[j+1] = arr[j] ^ arr[j+1];
                        arr[j] = arr[j] ^ arr[j+1];
                    }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public void test10(){
        HashMap map1 = new HashMap();
        map1.put("name","张三");
        map1.put("age",15);
        HashMap map2 = new HashMap();
        map2.put("name","李四");
        map2.put("age",16);
        HashMap map3 = new HashMap();
        map3.put("name",null);
        map3.put("age",null);

        List list = new ArrayList();
        list.add(map1);
        list.add(map2);
        list.add(map3);

        HashMap map = new HashMap();
        map.put("code",200);
        map.put("msg","成功");
        map.put("data",list);

        GsonBuilder builder = new GsonBuilder();
        String s = builder.serializeNulls().create().toJson(map);
        System.out.println(s);
    }

    @Test
    public void test13(){


    }
}
