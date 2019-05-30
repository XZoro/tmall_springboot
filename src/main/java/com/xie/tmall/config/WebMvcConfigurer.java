package com.xie.tmall.config;

import com.xie.tmall.intercepter.LoginInterceptor;
import com.xie.tmall.intercepter.OtherInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter{

    @Bean
    public OtherInterceptor getOtherIntercepter(){
        return new OtherInterceptor();
    }
    @Bean
    public LoginInterceptor getLoginIntercepter(){
        return new LoginInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getOtherIntercepter())
                .addPathPatterns("/**");
        registry.addInterceptor(getLoginIntercepter())
                .addPathPatterns("/**");
    }

}
