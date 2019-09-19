package com.car.admin.bean;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 学生基本信息表
 * </p>
 *
 * @author sunt
 * @since 2019-08-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("T_STUDENT")
public class StudentInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    @TableId("ID")
    @Excel(name = "学号", width = 20, orderNum = "1")
    private String id;

    /**
     * 姓名
     */
    @TableField("NAME")
    @Excel(name = "姓名", width = 20, orderNum = "2")
    private String name;

    /**
     * 性别(1:男 2:女)
     * replace:导出是{a_id,b_id} 导入反过来,注意大括号里面单独引号引起来的
     */
    @TableField("SEX")
    @Excel(name = "性别", width = 20, replace = { "男_1", "女_2" },orderNum = "3")
    private String sex;

    /**
     * 年龄
     */
    @TableField("AGE")
    @Excel(name = "年龄", width = 20, orderNum = "4")
    private Integer age;

    /**
     * 出生日期
     */
    @TableField("BIRTHDAY")
    @Excel(name = "出生日期", width = 20, orderNum = "5")
    private String birthday;

    /**
     * 入学时间
     */
    @TableField("REGIST_DATE")
    @Excel(name = "入学时间",width = 20,orderNum = "6")
    private String registDate;

    /**
     * 学费
     */
    @TableField("FEE")
    @Excel(name = "学费", width = 20, orderNum = "7")
    private BigDecimal fee;


}