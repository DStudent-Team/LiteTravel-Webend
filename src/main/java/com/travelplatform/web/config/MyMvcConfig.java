package com.travelplatform.web.config;

import com.travelplatform.web.component.LoginHandlerInterceptor;
import com.travelplatform.web.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    public LoginHandlerInterceptor loginHandlerInterceptor(){
        return new LoginHandlerInterceptor();
    }
    //Url格式，Example
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/travelPlatform").setViewName("success");
    }

    //网页配置化
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){
            //添加url进入格式
            @Override
            public void addViewControllers(ViewControllerRegistry registry){
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/user.html").setViewName("user");
                registry.addViewController("/register.html").setViewName("register");
                registry.addViewController("/main.html").setViewName("dashboard");
                registry.addViewController("/Cover.html").setViewName("cover");
                registry.addViewController("/hotel.html").setViewName("hotel");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //此处的ExcludePathPatterns排除特殊关键字被拦截的情况，例如静态资源，登录/注册页面，错误页面等。
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns( "/", "/login.html", "/cover", "/user/login",  "/toRegister/**", "/user/register", "/checkName", "/static/asserts/**", "/asserts/**", "/webjars/**", "/error");
            }

            //静态文件
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                //静态文件
                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
                //webjar文件
                registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
                //图片文件
                registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/asserts/img/");
            }

        };
    }
    //建立LocaleResolver 以屏蔽原默认设置的LocaleResolver
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
