package com.car.admin.mapper;

import com.car.admin.dto.Flow;
import com.car.admin.dto.User;
import org.apache.ibatis.annotations.*;

public interface IMapperLogin {

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "Account", property = "account"),
            @Result(column = "Password", property = "password"),
            @Result(column = "Token", property = "token"),
            @Result(column = "Status", property = "status")
    })
    @Select("select id,account,password,token,status from tbl_login where account=#{account}")
    User loginUser(User user);

    @Insert("insert into tbl_login (Account,Password) values (#{account},#{password})")
    void addUser(User user);


    @Insert("insert into tbl_login (Account) values (#{result})")
    void addAccount(String result);

    //存入流程表
    @Insert("insert into tbl_flow (FlowInfo) values (#{flowInfo})")
    void addFlow(Flow flow);

    @Update("update tbl_login set Status=1 where id=#{id}")
    void updateApplyUser(User user);
}
