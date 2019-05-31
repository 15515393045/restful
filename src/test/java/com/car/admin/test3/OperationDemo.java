package com.car.admin.test3;

public class OperationDemo {

    public static void main(String[] args) {

      int x = 1;
      int y = 2;

      int tmp = x;
      x = y;
      y = tmp;

        System.out.println(x);

        //两个相同的数 异或 之后结果会等于 0，即 n ^ n = 0。并且任何数与 0 异或等于它本身，即 n ^ 0 = n
        x = x ^ y;   // （1）
        y = x ^ y;   // （2）
        x = x ^ y;   //

        //System.out.println(y);

        //如果x、y两个值不相同，则异或结果为1。如果x、y两个值相同，异或结果为0。
        System.out.println(x ^ y);

        //一个数与自身异或结果为0,
        System.out.println(x ^ x);
        //一个数与0异或结果为其本身
        System.out.println(x ^ 0);

        System.out.println(9 ^ 0);

        System.out.println(99 ^ 3);

        // 一个数  与另  外一个数 异或两次结果是其本身
        System.out.println(6 ^ 7 ^ 7);
        System.out.println(6 ^ 7 ^ 6);

        System.out.println(1 ^ 2);

        System.out.println(3 ^ 1);

        System.out.println(98 ^ 99);

  /*    int[] arr = {1,4,2,3,6,5};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] < arr[j+1]){
                    //异或换位置
                    arr[j] = arr[j+1] ^ arr[j];
                    arr[j+1] = arr[j+1] ^ arr[j];
                    arr[j] = arr[j+1] ^ arr[j];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

  //利用异或的特性：两个相同的数异或的结果是 0，一个数和 0 异或的结果是它本身，来进行去重。
       /*
        1^2 = 3
        3^3 = 0
        0^4 = 4
        4^5 = 1
        1^1 = 0
        0^2 = 2
        2^3 = 1
        1^4 = 5
        */

    int[] arr = {1,2,3,4,5,1,2,3,4};
        //System.out.println(1^2^3^4^5^1^2^3^4);

        //System.out.println(find(arr));

        int m = 5;

        int n = 19;

        System.out.println(pow(m));

        System.out.println(findN(m));

        System.out.println(m >> 2);

        //或等于 |=
        //>>：按二进制形式把所有的数字向右移动对应巍峨位数，低位移出（舍弃），高位的空位补符号位，即正数补零，负数补1.
/*        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;

        System.out.println(n);*/

        System.out.println(find(n));
    }

    private static int find(int n){
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8; // 整型一般是 32 位，上面我是假设 8 位。
        return (n + 1) >> 1;    //16
    }

    //找出不大于N的最大的2的幂指数
    private static int findN(int N){
        int sum = 1;
        while(true){
            if(sum * 2 > N){
                return sum;
            }
            sum = sum * 2;
        }
    }

    //求m的n次方
    private static int pow(int m){
        int tmp = 1;
        for (int i = 1; i <= m; i++) {
             tmp = tmp * m;
        }
        return tmp;
    }

   private static int find(int[] arr){
        int tmp = arr[0];
        for(int i = 1;i < arr.length; i++){
            tmp = tmp ^ arr[i];
        }
        return tmp;
    }

}
