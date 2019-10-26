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

    //Url格式，Example
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/travelPlatform").setViewName("success");
    }

    //网页配置化
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer(){
            //添加url进入格式
            @Override
            public void addViewControllers(ViewControllerRegistry registry){
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html", "/", "/static/**", "/webjars/**", "/user/login");
            }

            //静态文件
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                //静态文件
                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
                //webjar文件
                registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

            }
//            //实现拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/", "/index.html", "/user/login", "classpath:/static/", "/webjars/", "/static/**", "/webjars/**", "/error");
//            }

//            //基于SpringBoot2.0更新，设置静态元素资源文件夹
//            @Override
//            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//                registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
//            }
        };
        return configurer;
    }
    //建立LocaleResolver 以屏蔽原默认设置的LocaleResolver
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
