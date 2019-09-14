package com.car.admin.test40;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {
        Map map = Collections.synchronizedMap(new HashMap<>());
    }

}
