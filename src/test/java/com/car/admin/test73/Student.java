package com.car.admin.test73;

import lombok.Data;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-04-19 16:11
 **/
@Data
public class Student {

    private static volatile  Student student = null;

    private Student(){}

    public static Student getStudent(){
        if(student == null){
            synchronized (Student.class){
                if(student == null){
                    student = new Student();
                }
            }
        }
        return student;
    }

    private String name;

    private Integer age;

    private String sex;

}
