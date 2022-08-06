package com.spring.demo.model;

import org.springframework.context.ApplicationEvent;

/**
 * @author beyondmars3
 */


public class UserLoginEvent extends ApplicationEvent {

    public UserLoginEvent(UserModel source) {
        super(source);
    }

}
