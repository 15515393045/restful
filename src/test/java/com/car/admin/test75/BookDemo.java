package com.car.admin.test75;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-09 20:36
 **/
public class BookDemo {

    public static void main(String[] args) {

        BookBean bookBean = new BookBean();

        System.out.println(bookBean.getId());
        System.out.println(bookBean.getAuthors());
        System.out.println(bookBean.getIsbn());
        System.out.println(bookBean.getName());
        System.out.println(bookBean.getPrice());
    }

}