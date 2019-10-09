package com.car.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.car.admin.bean.Jy.NoticeBean;
import com.car.admin.bean.mysql.MySQLConfigBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;

@Repository
@Mapper
public interface JyNoticeBeanMapper extends BaseMapper<NoticeBean> {

    @Select("select * from INFORMATION_SCHEMA.Columns where table_name = 'epc_vehicle_type' and table_schema='easyepc3.0'")
    List<MySQLConfigBean> findMySQLVehicleConfigInfo();

    @Select("select * from notice")
    List<NoticeBean> findNoticeInfo();

    @Select("select * from INFORMATION_SCHEMA.Columns where table_name = 'notice' and table_schema='easyepc3.0'")
    List<MySQLConfigBean> findMySQLNoticeConfig();

    @Select("select * from INFORMATION_SCHEMA.Columns where table_name = 'epc_vehicle_type' and table_schema='easyepc3.0'")
    List<LinkedHashMap<String,Object>> findMySQLEpcVehicleTypeConfig();
}
