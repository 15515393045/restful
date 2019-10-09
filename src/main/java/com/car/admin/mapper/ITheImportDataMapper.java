package com.car.admin.mapper;

import com.car.admin.bean.Jy.StuBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITheImportDataMapper {

    @Insert("insert into test_student (stuName,stuAge,stuSex) values ")
    void theImportExcelData(@Param("item") List<StuBean> item);

    @Select("select id,stuName name,stuAge age,stuSex sex from test_student")
    List<StuBean> testFindUser();

    @Insert("insert into test_student (stuName,stuAge,stuSex) values (#{name},#{age},#{sex})")
    void ImportExcelData(StuBean stuBean);
}
