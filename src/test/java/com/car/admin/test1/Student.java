package com.car.admin.test1;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private static final long serialVersionUID = -5659385610770578110L;

    private Integer id;

    private String stuName;

    private Integer stuAge;
}
