package com.car.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class User {

    private Integer id;

    @NotNull(message = "账号不能为空")
    @NotBlank(message = "账号不能为空")
    private String account;

    @NotNull(message = "密码不能为空")
    @NotBlank(message = "密码不能为空")
    private String password;
}
