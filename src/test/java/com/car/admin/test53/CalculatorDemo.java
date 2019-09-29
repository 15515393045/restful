package com.car.admin.test53;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-29 08:33
 **/
public class CalculatorDemo {

    public static double Calculator(char  sign, double oneNumber, double towNumber){
                switch (sign){
                    case '+':
                      double number = oneNumber+towNumber;
                        System.out.println(number);
                        return number;
                    case '-':
                        double number1 = oneNumber-towNumber;
                        System.out.println(number1);
                        return number1;
                    case '*':
                        double number2 = oneNumber*towNumber;
                        System.out.println(number2);
                        return number2;
                    case '/':
                        //0除以任何非零的数,都得0。
                        if(oneNumber==0.0) {
                            System.out.println("除数不能为0！");
                            break;
                        }
                        double number3 = oneNumber/towNumber;
                        System.out.println(number3);
                        return number3;
                    default:
                        System.out.println("请输入有效的字符！");
                        break;
                }
                return 0.0;
    }

    public static void main(String[] args) {
        double calculator = Calculator('*', 6, 3);
        double calculator1 = Calculator('+', calculator, 2);
        System.out.println(calculator1);
    }

}
