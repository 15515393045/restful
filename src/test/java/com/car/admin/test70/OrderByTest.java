package com.car.admin.test70;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-10-10 14:53
 **/
public class OrderByTest {

    public static void main(String[] args) {
        int result = factor1( 3);
        System.out.println(result);
        int result1 = factor(3);
        System.out.println("递归算法:内存消耗大容易内存溢出"+result1);
    }

    //---------------递归算法,方法本身调用自己----------------------
    public static int factor(int num){
        if (num==1) {
            return 1;
        }
        return num*factor(num-1);
    }

    //---------------普通计算----------------------
    public static int factor1(int num){
        int result = num;
        int i= num-1;
        do{
            result = result*i;
            i--;
        }while (i>1);
        return result;
    }

}
