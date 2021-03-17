package com.car.admin.test86;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-20 19:18
 **/
public class FastJsonTest {

    //json字符串-简单对象型
    private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";

    //json字符串-数组类型
    private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";

    //复杂格式json字符串
    private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    public static void main(String[] args) {

       /* int x = 4;
        int y = 1;
        if(x>2)//if省略{}大括号的情况下只能包住一行。
            if(y>2)
                System.out.println(x+y);
            //System.out.println("atguigu");
            else// 编译通过输出4，根据就近原则对应if(y>2)
            System.out.println(x);*/

     /* boolean b = true;

      if(b == false)
          System.out.println("a");
      else if (b)
          System.out.println("b");
      else if (!b)
          System.out.println("c");
      else
          System.out.println("d");*/


        int dogAge = 6;

        if(dogAge == 0){
            System.out.println("狗子刚出生。");
        }else if(dogAge == 1){
            System.out.println("狗子第一年相当于人类的10.5岁");
        }else if(dogAge == 2){
            System.out.println("狗子的第二年相当于人类的21岁");
        }else if(dogAge == 3){
            System.out.println("狗子的第三年相当于人类的25岁");
        }else if(dogAge == 4){
            System.out.println("狗子的第四年相当于人类的29岁");
        }else if(dogAge == 5){
            System.out.println("狗子的第五年相当于人类的33岁");
        }

        switch (dogAge){
            case 0:
                System.out.println("狗子刚出生。");
                break;
            case 1:
                System.out.println("狗子第一年相当于人类的10.5岁");
                break;
            case 2:
                System.out.println("狗子的第二年相当于人类的21岁");
                break;
            case 3:
                System.out.println("狗子的第三年相当于人类的25岁");
                break;
            case 4:
                System.out.println("狗子的第四年相当于人类的29岁");
                break;
            case 5:
                System.out.println("狗子的第五年相当于人类的33岁");
                break;
                default:
                    System.out.println("您的输入暂不识别。");
        }


        int DogAge = 2;
        if(DogAge >= 0 && DogAge <= 2){
            System.out.println("相当于人类年龄："+(DogAge * 10.5));
        }else if(DogAge > 2 ){
            System.out.println("相当于人类年龄："+(10.5 * 2 + (DogAge-2) * 4));
        }else {
            System.out.println("Error");
        }

    }

}



