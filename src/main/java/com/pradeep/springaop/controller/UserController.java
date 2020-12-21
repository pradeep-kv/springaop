package com.pradeep.springaop.controller;

import com.pradeep.springaop.model.User;
import com.pradeep.springaop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public String test(@RequestBody User user){
        String test = null;
        try {
            test =  userService.test("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }
}
