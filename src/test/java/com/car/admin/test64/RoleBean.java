package com.car.admin.test64;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-30 17:12
 **/
@Data
public class RoleBean implements Serializable {

    private String name;
    private int age;
    private String sex;

}
