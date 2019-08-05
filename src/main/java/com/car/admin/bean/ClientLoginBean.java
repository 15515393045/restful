package com.car.admin.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-05 11:05
 **/
@Data
public class ClientLoginBean implements Serializable {

    private static final long serialVersionUID = -9096336329778789914L;

    private Integer id;
    @NotNull(message = "账户不能为空！")
    @NotBlank(message = "账户不能为空！")
    private String clientName;
    @NotNull(message = "密码不能为空！")
    @NotBlank(message = "密码不能为空！")
    private String password;

    private Integer clientStatus;

    private Date lastTime;
}
