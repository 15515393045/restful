package com.car.admin.mapper;

import com.car.admin.dto.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IMapperUser {


    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "Name",property = "name"),
            @Result(column = "Age",property = "age")
    })
    @Select("select name,age from tbl_user")
    List<UserBean> findUser();

    @Insert("insert into tbl_user (Name,Age) values (#{name},#{age})")
    void addUser(UserBean user);

    @Update("update tbl_user set Name=#{name},Age=#{age} where id=#{id}")
    void updateUser(UserBean user);

    @Select("select name,age from tbl_user where id=#{value}")
    UserBean queryUserId(Integer userId);

    @Delete("delete from tbl_user where id = #{value}")
    void deleteUser(Integer id);
}
