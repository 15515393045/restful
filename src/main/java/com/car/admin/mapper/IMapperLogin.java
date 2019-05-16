package com.car.admin.mapper;

import com.car.admin.dto.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface IMapperLogin {

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "Account", property = "account"),
            @Result(column = "Password", property = "password")
    })
    @Select("select id,account,password from tbl_login where account=#{account}")
    User loginUser(User user);

}
