package com.car.admin.test75;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: demo-restful
 * @description:
 * 优先执行父类的静态方法。其次执行父类的静态块。然后执行子类的静态方法，其次执行子类的
 * 静态块。接着执行子类的非静态方法执行完毕后回到父类执行父类中的语句块紧接着执行父类中的
 * 构造方法。执行完毕后，回到子类执行子类的非静态方法，接着执行子类的语句块，子类的构造方法，
 *
 * 第二次实例化子类则不会在执行父类和子类中的静态方法和静态块，先执行子类的非静态方法，其次
 * 执行父类的语句块和构造方法执行完毕后回到子类执行子类的语句块和构造方法。
 * @author: zhanyh
 * @create: 2020-05-12 17:20
 **/
public class Son extends Father{

    private int i = Test();

    private static int j = Method();

    static {
        System.out.println("(6)");
    }

    Son(){
        System.out.println("(7)");
    }

    {
        System.out.println("(8)");
    }


    public int Test(){
        System.out.println("(9)");
        return 4;
    }


    public static int  Method(){
        System.out.println("(10)");
        return 5;
    }

    public static void main(String[] args) {
      /*  Son son1 = new Son();
        System.out.println("======================");
        Son son2 = new Son();
        System.out.println("======================");
        Son son3 = new Son();*/

        Map<String, Object> map = new HashMap<>();
        map.put("张三",18);
        map.put("里斯",19);
        map.put("王五",20);
        map.put("赵六",21);
      /*  if(map.containsKey("张三")){
            System.out.println("找到了叫张三的人"+map.get("张三"));
        }else{
            System.out.println("没有找到这个人。");
        }*/

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            String key = next.getKey();
            int value = (int) next.getValue();
            System.out.println(key+"===="+value);
        }

    }

}
