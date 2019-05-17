package com.car.admin.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRequest implements Serializable {

    private static final long serialVersionUID = 7689586780934459475L;

    private String name;


    private String age;
}
