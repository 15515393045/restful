package com.car.admin.test50;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRepeatableAnnotations {
    JDBCConfig[] value();
}
