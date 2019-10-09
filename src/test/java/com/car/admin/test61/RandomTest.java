package com.car.admin.test61;

import java.util.Random;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-30 14:20
 **/
public class RandomTest {
    public static void main(String[] args) {
   /*     Random random = new Random();
        //int x = random.nextInt();
        boolean b = random.nextBoolean();
        System.out.println(b);*/
        
       /** 
       * @Description:  
       *  E代表10，后面跟多少数字，就代表是10的多少次方
       *  在科学技术法中：当E后是正数时，只有从E7，
       *  也就是10的7次方开始才使用科学计数法表示，
       *  在E后是负数时，在E-4，也就是10的-4次方开始使用科学计数法表示。
       * @Author: zhanyh 
       * @Date: 2019/9/30 
       */
/*        System.out.println("double E1 = "+4.9E1);
        System.out.println("double E2 = "+4.9E2);
        System.out.println("double E3 = "+4.9E3);
        System.out.println("double E4 = "+4.9E4);
        System.out.println("double E-1 = "+4.9E-1);
        System.out.println("double E-2 = "+4.9E-2);
        System.out.println("double E-3 = "+4.9E-3);
        System.out.println("double E-4 = "+4.9E-4);*/

    /*    Random random = new Random();

        for (int i = 0; i < 50; i++) {
            if(i % 5 == 0){
                System.out.print("\n");
            }
            System.out.print(random.nextGaussian()+"\t");
        }*/

        //随机点名
        Random random = new Random();
        String[] names = {"张三","李四","王五"};
        //注意绑定限制的数字不会被随机出来也就是3不会被随机出来,包含0。 即：0~2之间
        String name = names[random.nextInt(3)];
        System.out.println(name);

    }
}
