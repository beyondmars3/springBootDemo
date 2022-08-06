package com.spring.demo.service;

import com.spring.demo.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

/**
 * @author beyondmars3
 */
@Slf4j
@Service
public class BookService {

    private int name;

    public BookService() {
        log.info("BookService construct name={}", name);
    }

    @PostConstruct
    public void init() {
        log.info("BookService init");
    }

    /**
     * getUserList
     *
     * @return
     */
    public List<UserModel> getUserList() {
        UserModel userModel = new UserModel();
        List<UserModel> userModelList = Collections.singletonList(userModel.of("fei", 1L));
        return userModelList;
    }


}
