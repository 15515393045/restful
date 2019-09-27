package com.car.admin.test46;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-20 17:50
 **/
public class LoopDemo {

    public static void main(String[] args) {
        for(int i=0;i<4;i++) {
            //循环5次后最外层循环一次
            for(int j=0;j<5;j++) {
                System.out.print("*"); //注意不是println。print将循环结果打印出来，println在每次循环后将结果打印出来并换行
            }
            System.out.print("\n"); //内部循环执行完一次后换行
        }

        int b=4;
        for (int i = 0; i < b; i++) {
            //根据最外层的循环次数进行循环
            for (int j = 0; j < i+1; j++) {
                System.out.print("☆");
            }
            System.out.print("\n");
        }


        // 由于只能用一次循环，且不知道次数所以用while去实现
        int i = 1;
        int j = 1;

        while (true) {
            // 程序出口
            if (i > 9) {
                break;
            }
            System.out.print(i + "*" + j + "=" + i * j + " ");
            if (j < i) {
                j++;
            } else {
                j = 1;
                i++;
                System.out.println();
                continue;
            }

        }

    }

}
