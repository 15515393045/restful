package com.car.admin.service.impl;

import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.bean.Jy.StuBean;
import com.car.admin.mapper.ITheImportDataMapper;
import com.car.admin.service.ITheImportDataTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-10-08 18:38
 **/
@Service("importService")
@Transactional(rollbackFor = Exception.class)
public class ITheImportDataTestImpl implements ITheImportDataTest {

    @Autowired
    private ITheImportDataMapper theImportDataMapper;

    @Override
    public ResponseResult theImportExcelData(List<StuBean> list) {
        theImportDataMapper.theImportExcelData(list);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult testFindUser() {
        List<StuBean> stuBeans = theImportDataMapper.testFindUser();
        System.out.println(stuBeans.toString());
        return ResponseResult.success(stuBeans);
    }

    @Override
    public void ImportExcelData(StuBean stuBean) {
        theImportDataMapper.ImportExcelData(stuBean);
    }
}
