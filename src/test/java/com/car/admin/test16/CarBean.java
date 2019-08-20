package com.car.admin.test16;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-20 14:10
 **/
@Data
public class CarBean implements Serializable {

    private static final long serialVersionUID = -6095090773312783051L;

    private Integer id;

    private String carName;

    private Double carPrice;

    private Integer carType;

    private String  carColour;

    public String carTime;

    public String car;
}
