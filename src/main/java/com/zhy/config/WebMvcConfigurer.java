package com.zhy.config;

import com.zhy.interceptor.LoginInterceptor;
import com.zhy.interceptor.OtherInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Bean
    public LoginInterceptor getLoginIntercepter() {
        return new LoginInterceptor();
    }

    @Bean
    public OtherInterceptor getOtherIntercepter() {
        return new OtherInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 静态资源的访问也会经过拦截器，而拦截器里面又写了对数据的访问。
         * 这样的话就连访问首页也会产生几十条重复的数据库查找。
         * 需要改善下！！
         */
        registry.addInterceptor(getLoginIntercepter())
                .addPathPatterns("/**");
        registry.addInterceptor(getOtherIntercepter())
                .addPathPatterns("/**");
    }



}