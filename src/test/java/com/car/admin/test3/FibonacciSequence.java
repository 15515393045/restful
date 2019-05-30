package com.car.admin.test3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

public class FibonacciSequence {

    //递归
    //一列数的规则如下: 1、1、2、3、5、8、13、21、34 ，求第30位数是多少？使用递归实现
    public static void main(String[] args) {
        //System.out.println(Fribonacci(9));


        //查看文件
/*        List<File> l = listFiles(new File("D:"));
        System.out.println("共" + l.size() + "个文件");
        for (File f : l) {
            System.out.println(f.getName());//(这里只打印了文件的文件名)
        }*/

        System.out.println(getSum(100));
    }

    public static int Fribonacci(int n) {

        if (n <= 2) {
            return 1;
        }else
            return Fribonacci(n - 1) + Fribonacci(n - 2);
    }

    /**
     * 找出指定目录下的所有文件
     * 递归
     *java中的isDirectory()是检查一个对象是否是文件夹。返回值是boolean类型的。如果是则返回true，否则返回false。
     * 调用方法为：对象.isDirectory() 无需指定参数。
     * @param files
     * @return
     */
    public static List<File> listFiles(File files){
        List<File> fileList = new ArrayList<>();
        if(files.isDirectory()){
            for (File file : files.listFiles()) {
                fileList.addAll(listFiles(file));
            }
        }else
            fileList.add(files);

        return fileList;
    }

    /**
     * 获取从1+到N的和
     *
     * @param num
     * @return
     */
    public static int getSum(int num) {
        if (num == 1) {
            return 1;
        }
        return num + getSum(num - 1);
    }
}
