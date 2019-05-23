package com.car.admin.test1;

import org.junit.Test;

public class test {

    @Test
    public void test1(){
        //学生类
        Student student = new Student();
        student.setId(2);
        student.setStuAge(15);
        student.setStuName("学生张三");

        //用户类
        User user = new User();
        user.setId(1);
        user.setUserAge("14");
        user.setUserName("用户李四");

        //字段类型一致,覆盖原有UserName的值
        user.setUserName(student.getStuName());
        System.out.println(user.getUserName());

        //类型不一样,通过转换也能编辑成功
        user.setUserAge(String.valueOf(student.getStuAge()));
        System.out.println(user.getUserAge());

        user.setId(student.getId());
        System.out.println(user.getId());

    }

}
