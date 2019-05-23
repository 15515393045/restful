package com.car.admin.test1;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 159369117843955789L;

    private Integer id;

    private String userName;

    private String userAge;
}
