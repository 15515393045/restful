package com.car.admin.test64;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-30 17:13
 **/
public class Test {

    public static void main(String[] args) {
        List<RoleBean> list = new ArrayList<>();
        RoleBean roleBean = null;
        Random random = new Random();
        for(int i=0;i<5;i++){
            roleBean = new RoleBean();
            roleBean.setAge(random.nextInt(3));
            list.add(roleBean);
        }
        for (int i = 0; i < list.size(); i++) {
            RoleBean roleBean1 = list.get(i);
            System.out.println(roleBean1.getAge());
        }
    }

}
