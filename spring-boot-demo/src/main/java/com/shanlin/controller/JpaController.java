package com.shanlin.controller;

import com.shanlin.model.JpaUser;
import com.shanlin.service.JpaUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hezuchao on 2017/6/8.
 */
@RestController
public class JpaController {
    @Autowired
    private JpaUserService jpaUserService;
    private static final Logger logger = LogManager.getLogger(JpaController.class.getName());

    @RequestMapping("getTest")
    public String test() {
        return "Hello World!!!";
    }

    @RequestMapping("getUser")
    public JpaUser getTestUser(@Param("id") Long id) {
        JpaUser user = jpaUserService.findById(id);
        logger.info("user: " + user);
        return user;
    }
}
