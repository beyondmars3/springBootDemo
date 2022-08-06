package com.spring.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author beyondmars3
 */
@Slf4j
@Component
public class AuthBeanPostProcessor implements BeanPostProcessor {

    public AuthBeanPostProcessor() {

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (BookService.class.isAssignableFrom(bean.getClass())) {
            log.info("BookService before");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (BookService.class.isAssignableFrom(bean.getClass())) {
            log.info("BookService after");
        }
        return bean;
    }
}
