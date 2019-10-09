package com.car.admin.test47;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-23 14:55
 **/
public class FileDemo {

    public static void main(String[] args) {

        File file = new File("F:/a.txt");
        String path = file.getPath();//绝对路径
        String name = file.getName();//文件名称
        System.out.println(path);
        System.out.println(name);
        String absolutePath = file.getAbsolutePath();//绝对路径
        System.out.println(absolutePath);
        long length = file.length();//文件大小
        System.out.println(length);
        String parent = file.getParent();//父路径
        System.out.println(parent);

        //使用日期类与日期格式化类进行获取规定的时间
        long l = file.lastModified();//
        Date date = new Date(l);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(date);
        System.out.println("最后一次修改的时间是："+format1);

        //文件或者文件夹的方法
        File[] files = File.listRoots();
        System.out.println("所有的盘符：");
        for (File file1 : files) {
            System.out.println("\t"+file1);
        }
        //  使用\\或者/否则报错
        File filename =new File("F:\\1806詹一恒");
        String[] list = filename.list();
        for (String s : list) {
            System.out.println("F:\\1806詹一恒文件夹下都有："+s);
        }

        File[] files1 = filename.listFiles();
        System.out.println("获得该路径下的文件或文件夹是：");
        for (File file1 : files1) {
            System.out.println("\t"+file1);
        }

/*   try {
            boolean newFile = file.createNewFile();
            if(newFile){
                System.out.println("创建成功");
            }else{
                System.out.println("创建失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
