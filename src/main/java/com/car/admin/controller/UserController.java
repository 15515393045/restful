package com.car.admin.controller;

import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.dto.UserBean;
import com.car.admin.enums.ServerResponse;
import com.car.admin.service.IServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IServiceUser serviceUser;

    //查询
    @GetMapping("info")
    public ServerResponse findUser(){
        return serviceUser.findUser();
    }

        //增加
     //@Valid
    //用于验证注解是否符合要求，直接加在变量user之前，在变量中添加验证信息的要求，当不符合要求时就会在方法中返回message                    的错误提示信息。结合@NotNull来使用
    @PostMapping("add")
    public ResponseResult addUser(@RequestBody @Valid UserBean user,BindingResult results){

            //进行为空校验,指定字段为空的话,返回对于的信息
            if(results.hasErrors()){
                return ResponseResult.fail(1,results.getFieldError().getDefaultMessage());
            }

            //处理异常
        try {
            return serviceUser.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.fail("增加失败1");
        }

    }

    //修改回显
    @GetMapping("queryId/{id}")
    public ResponseResult queryUserId(@PathVariable(value = "id")Integer userId){

            //进行为空校验,指定字段为空的话,返回对于的信息
                if(userId == null || userId == 0){
                    return  ResponseResult.fail("Id不能为空");
                }

        //处理异常
        try {
            return serviceUser.queryUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.fail("回显错误");
        }
    }

    //修改
    @PutMapping("update")
    public ResponseResult updateUser(@RequestBody @Valid UserBean user,BindingResult result){

        //进行为空校验,指定字段为空的话,返回对于的信息
            if(result.hasErrors()){
                return ResponseResult.fail(1,result.getFieldError().getDefaultMessage());
            }

            //处理异常
        try {
            return serviceUser.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.fail("修改失败1");
        }
    }

    //删除
    @DeleteMapping("delete/{id}")
    public ResponseResult deleteUser(@PathVariable(value = "id") @Valid Integer id){
        System.out.println();
        return serviceUser.deleteUser(id);
    }

    //批量删除
    @DeleteMapping("batch")
    public ResponseResult batchDeleteUser(String ids){
        return serviceUser.batchDeleteUser(ids);
    }

    //批量插入
    @PostMapping("batchAdd")
    public ResponseResult batchInsertUser(@RequestBody Map userDate){
        return serviceUser.batchInsertUser(userDate);
    }

    //分页查询
    @GetMapping("page")
    public ResponseResult queryUserPage(UserBean userBean, Integer start, Integer length){
        return serviceUser.queryUserPage(userBean, start, length);
    }
}
