package com.spring.demo.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author beyondmars3
 */
@Slf4j
@Data
public class UserModel {

    private String name;

    private Long userId;

    public UserModel() {
        log.info("UserModel construct");
    }


    public UserModel of(String name, Long userId) {
        this.name = name;
        this.userId = userId;
        return this;
    }
}
