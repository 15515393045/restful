package com.car.admin.test4;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 3257307760134272723L;

    private String name;

    private Integer age;

    private String   sex;
}
