package com.car.admin.bean.Jy;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-10-08 17:36
 **/
@Data
public class StuBean implements Serializable {

    private static final long serialVersionUID = 2396754774121389109L;

    private int    id;
    private String name;
    private String age;
    private String sex;
}
