package com.car.admin.controllerStuDySql;

import com.car.admin.annotation.AccessLimit;
import com.car.admin.enums.ResponseServer;
import com.car.admin.service.IStudySQL;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: demo-restful
 * @author: zhanyh
 * @create: 2019-06-30 21:30
 **/
@RestController
@RequestMapping("study")
public class StudySqlController {

    @Resource(name = "studyService")
    private IStudySQL iStudySQL;

    @GetMapping("profit_price")
    @AccessLimit(seconds = 60,maxCount = 5)
    public ResponseServer profitPrice(){
        return iStudySQL.profitPrice();
    }

    @GetMapping("brand_info")
    @AccessLimit(seconds = 60,maxCount = 5)
    public ResponseServer brandInfo() {
        return iStudySQL.brandInfo();
    }
}
