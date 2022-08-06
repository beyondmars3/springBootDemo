package com.spring.demo.controller;

import com.spring.demo.model.UserLoginEvent;
import com.spring.demo.model.UserModel;
import com.spring.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author beyondmars3
 */
@RestController
public class UserController {

    @Autowired
    private BookService bookService;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping("/")
    public String home() {
        return "welcome to home!";
    }

    @PostMapping("/getUser")
    public String getUser(@RequestBody UserModel userModel) {
        List<UserModel> userList = bookService.getUserList();
        String userStr = userList.stream().map(UserModel::getName).collect(Collectors.joining());
        return userStr;
    }

    @PostMapping("/getBook")
    public String getBook() {
        return "getBook";
    }

    @PostMapping("/login")
    public void login(@RequestBody UserModel userModel) {
        applicationEventPublisher.publishEvent(new UserLoginEvent(userModel));
    }

}
