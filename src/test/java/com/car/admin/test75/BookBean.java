package com.car.admin.test75;

/**
 * @program: demo-restful
 * @description: 图书实体类
 * @author: zhanyh
 * @create: 2020-05-09 20:31
 **/
public class BookBean {

    private long id;//编号

    private String name;//书名

    private String isbn;//书号

    private String[] authors;//作者们

    private double price;//价格


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
