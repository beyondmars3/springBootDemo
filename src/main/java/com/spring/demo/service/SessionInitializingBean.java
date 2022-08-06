package com.spring.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author beyondmars3
 */
@Slf4j
@Component
public class SessionInitializingBean implements InitializingBean {

    @Autowired
    private ApplicationContext applicationContext;

    SessionInitializingBean() {
        log.info("SessionInitializingBean construct");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).forEach(name -> log.info("beanDefinitionName={}", name));

        log.info("SessionInitializingBean afterPropertiesSet");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).forEach(name -> log.info("beanDefinitionName={}", name));
    }
}
