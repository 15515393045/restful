package com.car.admin.controller;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-06-21 22:33
 **/
@Data
public class StudentBean implements Serializable {

    private String name;

    private Integer age;

}
