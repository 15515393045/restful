package com.car.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.car.admin.bean.UserPlus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserPlus> {

}
