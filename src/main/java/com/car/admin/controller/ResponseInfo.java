package com.car.admin.controller;

import lombok.Data;

import java.util.List;

/**
 * @program: demo-restful
 * @create: 2019-06-25 20:25
 **/
@Data
public class ResponseInfo {

    private List<AreaInfo> area;

    private String province;

    private String type;

    private String operator;
}
