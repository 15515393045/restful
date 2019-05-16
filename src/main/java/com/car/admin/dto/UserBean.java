package com.car.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserBean implements Serializable {

    private static final long serialVersionUID = 2138520763556208965L;

    @NotNull(message = "Id不能为空")
    private Integer id;

    //如果为空则返回message的值   不能为null，但可以为empty
    @NotNull(message = "名字不能为空1")
    //只能作用在String上，不能为null，而且调用trim()后，长度必须大于0
    @NotBlank(message = "名字不能为空2")
    private String name;

    //结合使用
    @NotNull(message = "年龄不能为空1" )
    private Integer age;
}
