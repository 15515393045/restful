package com.car.admin.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-06-30 21:37
 **/
@Data
public class GoodsBean implements Serializable {
    /**
     * 市场价
     */
    private Double marketPrice;

    /**
     *成本价
     */
    private Double costPrice;

    /**
     *盈利价
     */
    private Double profitPrice;

    /**
     *商品名称
     */
    private String goodsName;
}
