package com.car.admin.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsPo {

    private Integer goodsId;

    private Integer catId;

    private Integer extendCatId;

    private String goodsSn;

    private String goodsName;

    private Integer clickCount;

    private Integer brandId;

    private Integer storeCount;

    private Integer commentCount;

    private Integer weight;

    private BigDecimal marketPrice;

    private BigDecimal shopPrice;

    private BigDecimal costPrice;

    private String keywords;

    private String goodsRemark;

    private String originalImg;

    private Integer isReal;

    private Integer isOnSale;

    private Integer isFreeShipping;

    private Integer onTime;

    private Integer sort;

    private Integer isRecommend;

    private Integer isNew;

    private Integer isHot;

    private Integer lastUpdate;

    private Integer goodsType;

    private Integer specType;

    private Integer giveIntegral;

    private Integer exchangeIntegral;

    private Integer suppliersId;

    private Integer salesSum;

    private Integer promType;

    private Integer promId;

    private BigDecimal commission;

    private String spu;

    private String sku;

    private String shippingAreaIds;

    private String goodsContent;

}