package com.car.admin.interfaceSafety;

import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.util.MD5Util;
import com.car.admin.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-22 21:19
 **/
@RestController
@RequestMapping("safety")
public class InterfaceSafety {

    private Long expire = 10L * 1000 * 60;

    @Value("${appKey}")
    private String appKey;
    @Value("${appSecret}")
    private String appSecret;

    /**
    * @Description:  checkSum  = appKey + appSecret + currentTime + nonce + MD5
    * @Param: [appKey, checkSum, currentTime, nonce]
    * @return: com.car.admin.ServerEnums.ResponseResult
    * @Author: zhanyh
    * @Date: 2019/8/22
    */
    @PostMapping("interfaceSafety")
    public ResponseResult interfaceSafety(String appKey,
                                          String checkSum,
                                          Long currentTime,
                                          String nonce){

        if(StringUtils.isEmpty(appKey)||StringUtils.isEmpty(checkSum)||
          StringUtils.isEmpty(nonce)||currentTime == null){
            return ResponseResult.fail(3000,"头信息不完整！");
        }

        Long serverTime = System.currentTimeMillis();
        if(serverTime - currentTime > expire){
            return ResponseResult.fail(3001,"请求超时！");
        }

        if(!RedisUtil.setnx(nonce,60)){
            return ResponseResult.fail(3002,"接口被攻击了！");
        }

        String newSign = appKey+appSecret+currentTime+nonce;
        String md5Sign = MD5Util.getStringMD5(newSign);
        if(!checkSum.equals(md5Sign)){
            return ResponseResult.fail(3003,"签名值错误！");
        }


    return ResponseResult.success();
    }

}
