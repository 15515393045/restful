package com.car.admin.test73;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-04-19 16:18
 **/
public class StudentTest {
    public static void main(String[] args) {
      /*  Student student1 = new Student();
        Student student2 = new Student();

        System.out.println(student1==student2);false */

        Student student1 = Student.getStudent();
        Student student2 = Student.getStudent();

        student1.setName("张三");
        student2.setName("李四");
        System.out.println(student1);
        System.out.println(student2);

        System.out.println(student1 == student2);
    }
}
