package com.car.admin.test5;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @program: demo-restful
 * @description: aa
 * @author: zhanyh
 * @create: 2019-06-04 16:19
 **/
public class test2 {

    public static void main(String[] args) throws IOException {
        String arr = "abcdefghigkimn";

        String[] split = arr.split("g", -1);

        for (String s : split) {
            System.out.println(s);
        }



        //向本地写文件
        FileWriter writer = new FileWriter("D:/llllllllllllllllll.text");
        writer.write("aaaa");
        writer.flush();
        writer.close();


        File file = new File("D:/llllllllllllllllll.text");

        if (file.isFile() && file.exists()){
            //构建度的输入流
            InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file),"UTF-8");

            BufferedReader bufferedReader = new BufferedReader(streamReader);

            System.out.println(bufferedReader.readLine());

            streamReader.close();
        }

    }
}
