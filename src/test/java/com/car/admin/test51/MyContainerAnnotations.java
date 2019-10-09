package com.car.admin.test51;

import java.lang.annotation.*;

//: 始终不会丢弃，运行期也保留该注解，
// 因此可以使用反射机制读取该注解的信息。
// 我们自定义的注解通常使用这种方式。
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})//可以用在类和方法上
@Documented//注解是否将包含在JavaDoc中
public @interface MyContainerAnnotations {
    RepeatUseAnnotations[] value();
}
