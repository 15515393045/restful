package com.car.admin.bean.mysql;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-24 13:23
 **/
@Data
public class MySQLConfigBean implements Serializable {

    private static final long serialVersionUID = 4456817305769104444L;
    //映射不上数据跟属性名称的书写有关，不能跟数据库一样，要符合驼峰命名法
    private String tableCatalog;
    private String tableSchema;
    private String tableName;
    private String columnName;
    private String ordinalPosition;
    private String columnDefault;
    private String isNullable;
    private String dataType;
    private String characterMaximumLength;
    private String characterOctetLength;
    private String numericPrecision;
    private String numericScale;
    private String datetimePrecision;
    private String characterSetName;
    private String collationName;
    private String columnType;
    private String columnKey;
    private String extra;
    private String privileges;
    private String columnComment;
    private String generationExpression;

}
