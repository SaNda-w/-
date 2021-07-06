package com.jin.acc.config;

import com.jin.acc.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyConfig implements WebMvcConfigurer {


   @Bean
    public UserLoginInterceptor getUserLoginInterceptor(){
       return new UserLoginInterceptor();
    }

   @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(getUserLoginInterceptor())
                .addPathPatterns("/manager");

       registry.addInterceptor(getUserLoginInterceptor())
               .addPathPatterns("/add");
   }
}
