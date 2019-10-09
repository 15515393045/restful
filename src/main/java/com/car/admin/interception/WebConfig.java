
package com.car.admin.interception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo-restful
 * @description: 配置类
 * @author: zhanyh
 * @create: 2019-05-31 09:48
 **/
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {


/**
    * @Description: 添加拦截器实例
    * @Param: [registry]
    * @return: void
    * @Author: zhanyh
    * @Date: 2019/5/31
    */

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        List list = new ArrayList();
        list.add("/user/json");
        list.add("/user/batchAdd");
        list.add("/user/testJson");
        list.add("/user/testArea");
        list.add("/user/queryGoods");
        list.add("/user/clientLogin");
        list.add("/study/profit_price");
        list.add("/study/brand_info");
        list.add("/login/user");
        list.add("/user/userLogin");
        list.add("/safety/interfaceSafety");
        //放过测试Swagger请求的方法
        list.add("/moerService/access");
        list.add("/moerService/test");
        list.add("/export/exportStudent");
        //  /**拦截所有请求放过json请求
        registry.addInterceptor(new Interception()).addPathPatterns("/**").excludePathPatterns(list);


        super.addInterceptors(registry);
    }
    

/**
    * @Description:项目启动时被加载 静态文件访问配置
    * @Param: [registry] 
    * @return: void 
    * @Author: zhanyh
    * @Date: 2019/5/31 
    */

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //放过静态资源文件
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //放过Swagger请求
        //解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        //解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

        super.addResourceHandlers(registry);
    }


/**
    * @Description: 视图配置
    * @Param: [registry]
    * @return: void
    * @Author: zhanyh
    * @Date: 2019/5/31
    */

    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {



       /*jsp视图解析器，对模型视图名称的解析，即在模型视图名称添加前后缀
        如/view/welcome.jsp对应的视图名就是：welcome
        这个类在视图解析器链中一定要定义在其他视图的后面，因为它始终会返回一个视图*/

        registry.jsp("/WEB-INF/",".jsp");

        super.configureViewResolvers(registry);
    }


/**
    * @Description: 方法及参数描述
     *     addInterceptors(InterceptorRegistry registry)：添加拦截器，并且配置拦截路径等参数
     * 　　addInterceptor(new CheckFilter())：添加实例化的拦截器
     * 　　addPathPatterns("/**") ：配置拦截器拦截的路径
     * 　　excludePathPatterns("/testBean/test")：配置不进去拦截器的方法，
     *    多少个就可以像这样儿在后面一直添加，excludePathPatterns("/testBean/test","","",........).
     * ddResourceHandlers(ResourceHandlerRegistry registry)：静态文件访问配置
     * onfigureViewResolvers(ViewResolverRegistry registry)：试图配置
    */

}

