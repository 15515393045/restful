package com.car.admin.test67;

import com.alibaba.fastjson.JSON;
import com.car.admin.bean.Jy.StuBean;
import com.car.admin.mapper.ITheImportDataMapper;
import com.car.admin.service.ITheImportDataTest;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-10-08 16:47
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TheImportDemo {

    public static final Logger log = LoggerFactory.getLogger(TheImportDemo.class);

    @Autowired
    private ITheImportDataTest theImportDataTest;

    @Autowired
    private ITheImportDataMapper theImportDataMapper;

    @Test
    public void test1() throws IOException {
        List<StuBean> test = test();
        String s = JSON.toJSONString(test);
        System.out.println(s);
        theImportDataTest.theImportExcelData(test);
    }

    public static List test() throws IOException {
        List<StuBean> list = new ArrayList<>();
        File file = new File("E:/Student.xls");
        if (!file.isFile() && file.exists()) { return null; }
        //.是特殊字符，需要转义！！！！！
        String[] split = file.getName().split("\\.");
        FileInputStream xls = null;
        HSSFWorkbook excelFile = null;
        //根据文件后缀（xls/xlsx）进行判断
        if ("xls".equals(split[1])) {
            //构建读取文件流对象
            xls = new FileInputStream(file);
            excelFile = new HSSFWorkbook(xls);
        }else if("xlsx".equals(split[1])){
            excelFile = new HSSFWorkbook(xls);
        }else {
            System.out.println("文件类型错误，请检查文件类型！");
            return null;
        }

        log.info("开始解析,Excel类型的文件。");

        //读取sheet页下标从0开始
        HSSFSheet sheetAt = excelFile.getSheetAt(0);
        //+1是为了跳过列名。可以不读
        int firstRowIndex  = sheetAt.getFirstRowNum() + 1;
        //获取最后一行数据的行数
        int lastRowNum = sheetAt.getLastRowNum();
        //遍历行
        for(int i = firstRowIndex; i<=lastRowNum; i++){
            Row row = sheetAt.getRow(i);
            if(row != null){
                int firstCellIndex = row.getFirstCellNum();
                int lastCellIndex = row.getLastCellNum();
                List list1 = new ArrayList();
                //定义存放数据的对象。
                StuBean studentBean = new StuBean();
                String stringCellValue = "";
                StringBuilder stringBuilder = new StringBuilder();
                for(int j = firstCellIndex; j<lastCellIndex; j++){
                    Cell cell = row.getCell(j);
                    if(cell == null){return null;}
                    stringCellValue = cell.toString();
                    stringBuilder.append(stringCellValue).append(",");
                }
                //分割映射JavaBean
                String[] split1 = stringBuilder.toString().split(",");
                studentBean.setName(split1[0]);
                studentBean.setAge(split1[1]);
                studentBean.setSex(split1[2]);
                list.add(studentBean);
            }
        }
        return list;
    }
}
