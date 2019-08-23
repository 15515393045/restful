package com.car.admin.test20;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-22 16:18
 **/
public class OrderDemo {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){

                    arr[j] = arr[j+1] ^ arr[j];
                    arr[j+1] = arr[j+1] ^ arr[j];
                    arr[j] = arr[j+1] ^ arr[j];

                }
            }

        }
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            System.out.println(i1);
        }
    }

}
