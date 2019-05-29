package com.car.admin.test2;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;

public class UserBean {

    /*@Expose 想让谁输出谁输出*/
    @Expose
    /*@SerializedName 想怎么显示怎么显示*/
    @SerializedName("名字")
    private String name;

    //前提是设置setVersion(3.2)
    /*@Since、@Until 不同版本不同数据*/
    @Expose
    @SerializedName("年龄")
    //@Since标注的在 3.2 版本或之后才会输出
    @Since(3.2)
    private int    age;

    @Expose
    @SerializedName("性别")
    //@Until标注的只在 3.2 版本前才有
    @Until(3.3)
    private String sex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
