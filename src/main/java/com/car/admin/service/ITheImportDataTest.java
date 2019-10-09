package com.car.admin.service;


import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.bean.Jy.StuBean;

import java.util.List;

public interface ITheImportDataTest {

    ResponseResult theImportExcelData(List<StuBean> list);

    ResponseResult testFindUser();

    void ImportExcelData(StuBean stuBean);
}
