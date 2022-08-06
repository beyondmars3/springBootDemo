package com.spring.demo.service;

import com.spring.demo.model.UserLoginEvent;
import com.spring.demo.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author beyondmars3
 */
@Slf4j
@Component
public class LoginListener implements ApplicationListener<UserLoginEvent> {

    @Override
    public void onApplicationEvent(UserLoginEvent userLoginEvent) {

        UserModel userModel = (UserModel) userLoginEvent.getSource();
        log.info("user {} login at time {}", userModel.getName(), userLoginEvent.getTimestamp());
    }

}
