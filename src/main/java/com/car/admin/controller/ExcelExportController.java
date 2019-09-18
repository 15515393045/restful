package com.car.admin.controller;

import com.car.admin.bean.StudentInfoBean;
import com.car.admin.mapper.StudentMapperPlus;
import com.car.admin.util.MyExcelExportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-16 20:59
 **/
@Controller
@RequestMapping("export")
public class ExcelExportController {

    @Autowired
    private StudentMapperPlus studentMapperPlus;

    @RequestMapping("exportStudent")
    public void exportStudent(HttpServletResponse response) {
        try {
            List<StudentInfoBean> sutdentList = studentMapperPlus.selectList(null);
            MyExcelExportUtil.exportExcel(sutdentList,StudentInfoBean.class,"学生基本信息","新生入学信息",response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


