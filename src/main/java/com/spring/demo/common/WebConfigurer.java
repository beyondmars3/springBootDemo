package com.spring.demo.common;

import com.spring.demo.model.UserModel;
import com.spring.demo.service.LoginHandlerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author beyondmars3
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public LoginHandlerInterceptor loginHandlerInterceptor() {
        return new LoginHandlerInterceptor();
    }

    @Bean()
    public UserModel userModel() {
        UserModel userModel = new UserModel();
        userModel.setName("xiaoLong");
        return userModel;
    }
}
