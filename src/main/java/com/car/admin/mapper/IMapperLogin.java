package com.car.admin.mapper;

import com.car.admin.dto.User;
import org.apache.ibatis.annotations.*;

public interface IMapperLogin {

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "Account", property = "account"),
            @Result(column = "Password", property = "password")
    })
    @Select("select id,account,password from tbl_login where account=#{account}")
    User loginUser(User user);

    @Insert("insert into tbl_login (Account,Password) values (#{account},#{password})")
    void addUser(User user);
}
