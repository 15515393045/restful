package com.car.admin.mapper;

import com.car.admin.dto.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface IMapperUser {


    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "Name",property = "name"),
            @Result(column = "Age",property = "age")
    })
    @Select("select id,name,age from tbl_user")
    List<UserBean> findUser();

    @Insert("insert into tbl_user (Name,Age,userImg) values (#{name},#{age},#{userImg})")
    void addUser(UserBean user);

    @Update("update tbl_user set Name=#{name},Age=#{age} where id=#{id}")
    void updateUser(UserBean user);

    @Select("select name,age from tbl_user where id=#{value}")
    UserBean queryUserId(Integer userId);

    @Delete("delete from tbl_user where id = #{value}")
    void deleteUser(Integer id);

    //通过xml文件进行批量删除
    void batchDeleteUser(List<Integer> idsList);

    //批量插入
    void batchInsertUser(List<UserBean> userList);

    //获取总条数
    Long queryCountList(UserBean userBean);

    //获取分页列表
    List<UserBean> queryUserPage(UserBean userBean);
}
