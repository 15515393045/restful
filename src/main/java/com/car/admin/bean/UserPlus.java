package com.car.admin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-06 15:03
 **/
@Data
@TableName(value = "tbl_user")
public class UserPlus {

    @TableId(value = "id",type = IdType.AUTO)
    private int id;

    //姓名
    @TableField("userName")
    private String name;

    //年龄
    @TableField("userAge")
    private int age;

    //工号
    @TableField("userNumber")
    private String jobNumber;

    //性别
    @TableField("userSex")
    private String sex;

    //入职日期
    @TableField("userDate")
    private Date entryDate;

    //家庭成员数量
    @TableField("userFamily")
    private BigDecimal familyMemberQuantity;

}
