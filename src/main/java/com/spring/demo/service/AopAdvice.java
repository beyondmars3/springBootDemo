package com.spring.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author beyondmars3
 */
@Slf4j
@Aspect
@Component
public class AopAdvice {

    @Pointcut("execution (* com.spring.demo.service.BookService.*(..))")
    public void log() {

    }

    @Around("log()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("Aspect before");
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        log.info("Aspect after");
        return result;
    }

}
