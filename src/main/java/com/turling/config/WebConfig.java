package com.turling.config;
import com.turling.interceptor.LoginInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@MapperScan("com.turling.dao")
public class WebConfig implements WebMvcConfigurer {
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/*")
        .excludePathPatterns("/","/login","bootstrap/**","js/**");
    }

    //配置视图
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/easyiu").setViewName("easyiu");
        registry.addViewController("/login2").setViewName("login2");
        registry.addViewController("/layout").setViewName("layout");
        registry.addViewController("/nav").setViewName("nav");
        registry.addViewController("/west2").setViewName("west2");
        registry.addViewController("/west3").setViewName("west3");
        registry.addViewController("/menus").setViewName("menus");
        registry.addViewController("/emp").setViewName("emp");
    }
}
