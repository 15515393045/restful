package com.car.admin.controller;

import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.dto.UserBean;
import com.car.admin.enums.ServerResponse;
import com.car.admin.service.IServiceUser;
import com.car.admin.util.CosUploadUtil;
import com.car.admin.util.FileUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.net.StandardSocketOptions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IServiceUser serviceUser;

    /**
    * @Description: 查询 
    * @Param: [] 
    * @return: com.car.admin.enums.ServerResponse 
    * @Author: zhanyh
    * @Date: 2019/5/30 
    */
    @GetMapping("info")
    public ServerResponse findUser(){
        return serviceUser.findUser();
    }

    /**
    * @Description:  增加
    * @Param: [user, results] 
    * @return: com.car.admin.ServerEnums.ResponseResult 
    * @Author: zhanyh
    * @Date: 2019/5/30 
    */ 
    //@Valid
    //用于验证注解是否符合要求，直接加在变量user之前，在变量中添加验证信息的要求，当不符合要求时就会在方法中返回message的错误提示信息。结合@NotNull来使用
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

    /**
    * @Description: 修改回显 
    * @Param: [userId] 
    * @return: com.car.admin.ServerEnums.ResponseResult 
    * @Author: zhanyh
    * @Date: 2019/5/30 
    */ 
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

     /**
     * @Description: / + q + Tab
     * @Param: [user, result]
     * @return: com.car.admin.ServerEnums.ResponseResult
     * @Author: zhanyh
     * @Date: 2019/5/30
     */
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
    /**
    * @Description:  删除
    * @Param: [id] 
    * @return: com.car.admin.ServerEnums.ResponseResult 
    * @Author: zhanyh
    * @Date: 2019/5/30 
    */
    @DeleteMapping("delete/{id}")
    public ResponseResult deleteUser(@PathVariable(value = "id") @Valid Integer id){
        System.out.println();
        return serviceUser.deleteUser(id);
    }
    
    /**
    * @Description:  批量删除
    * @Param: [ids] 
    * @return: com.car.admin.ServerEnums.ResponseResult 
    * @Author: zhanyh
    * @Date: 2019/5/30 
    */
    @DeleteMapping("batch")
    public ResponseResult batchDeleteUser(String ids){
        return serviceUser.batchDeleteUser(ids);
    }

    /**
    * @Description: 批量插入 
    * @Param: [userDate] 
    * @return: com.car.admin.ServerEnums.ResponseResult 
    * @Author: zhanyh
    * @Date: 2019/5/30 
    */ 
    @PostMapping("batchAdd")
    public ResponseResult batchInsertUser(@RequestBody Map userDate){
        return serviceUser.batchInsertUser(userDate);
    }

    /**
    * @Description: 分页查询 
    * @Param: [userBean] 
    * @return: com.car.admin.ServerEnums.ResponseResult 
    * @Author: zhanyh
    * @Date: 2019/5/30 
    */ 
    @GetMapping("page")
    public ResponseResult queryUserPage(UserBean userBean){
        return serviceUser.queryUserPage(userBean);
    }

    /**
    * @Description: 图片上传 
    * @Param: [uploadFile] 
    * @return: com.car.admin.ServerEnums.ResponseResult 
    * @Author: zhanyh
    * @Date: 2019/5/30 
    */ 
    @PostMapping("file")
    public ResponseResult FileInput(@RequestParam MultipartFile uploadFile){

        InputStream stream = null;
        try {
            stream = uploadFile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filename = uploadFile.getOriginalFilename();

        String path = request.getServletContext().getRealPath("img/");

        String newFileName = FileUtil.copyFile(stream, filename, path);

        String browsePath = CosUploadUtil.cosUtil(stream, newFileName);

        return ResponseResult.success(browsePath);
    }

    /**
    * @Description: 训练Json格式的嵌套 
    * @Param: [] 
    * @return: com.car.admin.ServerEnums.ResponseResult 
    * @Author: zhanyh
    * @Date: 2019/5/30 
    */ 
    @GetMapping("json")
    public ResponseResult findJson(){
      return serviceUser.findJson();
    }

    //用list接收参数需要指明泛型否则会报错
    @PostMapping("testJson")
    public void testJson(@RequestBody Map<String,List<StudentBean>> map){
        //JavaBean和Map的JSON格式一样
        List<StudentBean> studentBeans = map.get("data");
        for (StudentBean studentBean : studentBeans) {
            System.out.println(studentBean.getName());
            System.out.println(studentBean.getAge());
        }
    }

    @PostMapping("testArea")
    public ResponseResult getRequest(@RequestBody Map<String,Object> map) {

        Map<String,Object> response = (Map<String, Object>) map.get("response");

        Map<String,Object> phoneInfoType = (Map<String, Object>) response.get("18301600000");
        String location = (String) phoneInfoType.get("location");
        System.out.println(location);

        Map<String,Object> detail = (Map<String, Object>) phoneInfoType.get("detail");


        Gson gson = new Gson();
        //将获取的数据转换为JSON格式的字符串
        String detailInfo = gson.toJson(detail);
        System.out.println(detailInfo);
        //将JSON格式的字符串序列化到JavaBean中
        ResponseInfo responseInfo = gson.fromJson(detailInfo, ResponseInfo.class);

        List<AreaInfo> area = responseInfo.getArea();
        for (AreaInfo areaInfo : area) {
            System.out.println(areaInfo.getCity());
        }

        return ResponseResult.success();
    }
}
