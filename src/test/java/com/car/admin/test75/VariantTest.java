package com.car.admin.test75;

/**
 * @program: demo-restful
 * @description: 无论创建多少个实例对象
 * （VariantTest variantTest1 = new VariantTest();）
 *  永远都值分配一个 staticVar 变量。并且每创建一个实例对象，
 *  这个 staticVar 类变量就会加1; 但是每创建一个实例对象就会
 *  分配一个 instanceVar ,即可能分配多个 instanceVar, 并且每个
 *   instanceVar 的值都加了一次。
 * @author: zhanyh
 * @create: 2020-05-09 20:40
 **/
public class VariantTest {

    public static int staticVar = 0;//类变量,位于方法区

    public int instanceVar = 0;//实例变量,位于堆内存

    public VariantTest(){
        staticVar++;
        instanceVar++;
        //类被调用几次就会有几个类变量
        System.out.println("静态成员变量："+staticVar);
        //因实例变量所存在堆空间中，其内存地址不一样引用所指向的指也不是同一个,
        // 所以每次都是1,除非该实例的引用指向同一个空间。
        System.out.println("实例成员变量："+instanceVar);
    }

    /*public static void main(String[] args) {
        int[] arrys = {2,5,7,8,1,10};
        System.out.println("数组长度："+arrys.length);
        for (int i = 0; i < arrys.length-1; i++) {
            for (int j = 0; j < arrys.length-1-i; j++) {
                 if (arrys[j] > arrys[j+1]){
                     System.out.println("asd "+arrys[j] );
                     *//*int s = arrys[j];
                     arrys[j] = arrys[j+1];
                     arrys[j+1] = s;*//*

                     //异或换位置
                     arrys[j] = arrys[j+1] ^ arrys[j];
                     arrys[j+1] = arrys[j+1] ^ arrys[j];
                     arrys[j] = arrys[j+1] ^ arrys[j];
                 }
            }
        }
        for (int i = 0; i < arrys.length; i++) {
            int arry = arrys[i];
            System.out.println(arry);
        }
    }*/

    public static int[] BigBubbleSort(int[] arr){
        // 外层循环控制比较轮数
        for (int i = 0; i < arr.length-1; i++) {
            // 内层循环控制每轮比较次数
            for (int j = 0; j < arr.length-1-i; j++) {
                // 按照从小到大排列
                if(arr[j] > arr[j+1]){
                    int s = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = s;
                }
            }
        }
        return arr;
    }

    public static int[] SmallBubbleSort(int[] arr){
        // 外层循环控制比较轮数
        for (int i = 0; i < arr.length-1; i++) {
            // 内层循环控制每轮比较次数
            for (int j = 0; j < arr.length-1-i; j++) {
                // 按照从小到大排列
                if(arr[j] < arr[j+1]){
                    int s = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = s;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
     /*   VariantTest variantTest = new VariantTest();
        int[] arr = {2,5,7,1};
        int[] ints = variantTest.bubbleSort(arr);
        for (int i = 0; i < ints.length; i++) {
            int anInt = ints[i];
            System.out.println(anInt);
        }*/

        int[] sorted = SmallBubbleSort(new int[] { 2, 5, 0 });
        for (int i : sorted) {
            System.out.print(i + "\t");
        }
    }


}
