package com.car.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRestfulApplicationTests {

    @Test
    public void contextLoads() {


        int a = 0;
        float b = (float) 3.14;

        double c = 3.15;

        String name = "";

        a = Integer.parseInt(name);

        System.out.println(a);
    }

}
