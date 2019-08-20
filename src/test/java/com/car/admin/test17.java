package com.car.admin;

import org.assertj.core.data.Index;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-20 09:57
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class test17 {

    @Test
    public void test(){

        int i = 1%11;

        System.out.println(i);

    }

    /**
     * @Date:     2018/10/22
     * @describe: 简单的轮训算法...
     *              简介: 1. 将目标放置一容器内.
     *                    2. 定义一标识, 记录上次访问的该目标对象(标识应该是索引等, 需要有规律性)
     *                    3. (该标识 + 1) 取模, 然后获取到该目标对象. 同时更新该目标标识
     * @return : null
     * @throws:
     */
    @Test
    public void test1(){
        int i = 0;

        int[] arr = {10,9,8,7,6,5,4,3,2,1,0};

        int index = 0;
        for (; i < 11; i++) {
            int nextIndex = (index + 1) % arr.length;
             index = nextIndex;
            System.out.println(arr[index]);
        }
    }

}
