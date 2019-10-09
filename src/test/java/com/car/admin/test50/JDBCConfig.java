package com.car.admin.test50;

import java.lang.annotation.*;


//: 始终不会丢弃，运行期也保留该注解，
// 因此可以使用反射机制读取该注解的信息。
// 我们自定义的注解通常使用这种方式。
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})//可以用在类或者方法上
@Documented
@Repeatable(MyRepeatableAnnotations.class)
public @interface JDBCConfig {

    String ip();
    int port();
    String database();
    String encoding();
    String loginName();
    String password();

}
