package com.car.admin.service.impl;

import com.car.admin.bean.BrandBean;
import com.car.admin.bean.GoodsBean;
import com.car.admin.enums.ResponseServer;
import com.car.admin.mapper.IStudySQLMapper;
import com.car.admin.service.IStudySQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-06-30 21:36
 **/
@Service("studyService")
public class IStudySQLImpl implements IStudySQL {

    @Autowired
    private IStudySQLMapper iStudySQLMapper;

    @Override
    public ResponseServer profitPrice() {
        List<GoodsBean> goodsBeans = iStudySQLMapper.profitPrice();
        return ResponseServer.success(goodsBeans);
    }

    @Override
    public ResponseServer brandInfo() {
        List<BrandBean> brandBeans = iStudySQLMapper.brandInfo();
        return ResponseServer.success(brandBeans);
    }

}
