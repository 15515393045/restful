package com.car.admin.test60;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-29 17:48
 **/
public class TestList {

    public static void main(String[] args) {
        //定义标志dap;
        dap:for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                System.out.println(j);
                //跳出指定的dap循环。
                break dap;
            }
        }
        //循环条件表达式方法。
        boolean isReturn = false;
        for(int i = 0; i < 5 && !isReturn; i++){
            for(int j = 0; j<5; j++){
                if(j ==4 && i == 3){
                    isReturn = true;
                    break;
                }
            }
        }
    }

}
