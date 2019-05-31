package com.car.admin;


import javafx.util.Builder;
import org.junit.Test;
import org.springframework.util.concurrent.SuccessCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
}
