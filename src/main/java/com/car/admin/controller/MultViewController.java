package com.car.admin.controller;

import com.car.admin.dto.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo/lsh/ch5")
@Scope("prototype")
public class MultViewController {

    private static int st = 0;      //静态的
    private int index = 0;          //非静态

    @RequestMapping("/show")
    public String toShow(ModelMap model) {
        User user = new User();
        user.setAccount("testuname");
        user.setPassword("23");
        model.put("user", user);
        return "/lsh/ch5/show";
    }

    @RequestMapping("/test")
    public String test() {
        System.out.println(st++ + " | " + index++);
        return "/lsh/ch5/test";
    }

}
