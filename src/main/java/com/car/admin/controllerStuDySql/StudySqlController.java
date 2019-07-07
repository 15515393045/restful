package com.car.admin.controllerStuDySql;

import com.car.admin.enums.ServerResponse;
import com.car.admin.service.IStudySQL;
import org.springframework.stereotype.Controller;
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
    public ServerResponse profitPrice(){
        return iStudySQL.profitPrice();
    }

    @GetMapping("brand_info")
    public ServerResponse brandInfo() {
        return iStudySQL.brandInfo();
    }
}
