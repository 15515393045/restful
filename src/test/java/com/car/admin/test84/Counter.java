package com.car.admin.test84;

import java.lang.annotation.*;

//作用于类,方法,参数,构造器,域(包括 enum 实例)上。
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.PARAMETER,
        ElementType.CONSTRUCTOR,ElementType.FIELD})
//注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Retention(RetentionPolicy.RUNTIME)
//说明该注解将被包含在javadoc中
@Documented
public @interface Counter {
    //default 设置默认值为0
    int number() default 520;

    String str() default "詹一恒";
}
