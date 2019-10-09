package com.car.admin.bean.Jy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("notice")
public class NoticeBean implements Serializable {

    private static final long serialVersionUID = -3794164273197731961L;

    @TableId(value = "id",type = IdType.AUTO)
    private String id;
    @TableField("title")
    private String title;
    @TableField("content")
    private String content;
    @TableField("version")
    private String version;
    @TableField("operator_id")
    private String operatorId;
    @TableField("platform_flag")
    private String platformFlag;
    @TableField("create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @TableField("update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @TableField("end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}