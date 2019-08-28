package com.car.admin.swagger;

import com.car.admin.ServerEnums.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: demo-restful
 * @description: 测试Swagger
 * @author: zhanyh
 * @create: 2019-08-27 22:29
 **/
@RestController
@RequestMapping("moerService")
@Api(value = "Access-Controller", description = "Swagger测试服务")
public class AccessController {


    @RequestMapping(value = "access", method = RequestMethod.POST)
    @ApiOperation(value = "入口方法", notes = "将token、apiCode、version、businessParams组合为Map(Json)类型参数")
    @ApiImplicitParam(paramType = "body", name = "params", value = "组合参数", required = true, dataType = "Map(Json)")
    public ResponseResult access(@RequestBody Map params) throws Exception {

        String name = (String) params.get("name");

        return ResponseResult.success(name);
    }

    //@RequestMapping(value = "/checkedSku",method = {RequestMethod.POST,RequestMethod.GET},produces = "application/json;charset=UTF-8")
    @RequestMapping(value = "test", method = RequestMethod.POST)
    @ApiOperation(value = "测试方法", notes = "模拟用户访问")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "time", value = "时间", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "site", value = "地点", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "figure", value = "人物", required = true, dataType = "String")
    })
    public String test(@RequestParam(value = "time",required = true) String time,
                       @RequestParam(value = "site",required = true) String site,
                       @RequestParam(value = "figure",required = true) String figure) {

        return time+site+figure+"在吃饭！";
    }


}
