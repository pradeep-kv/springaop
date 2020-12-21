package com.pradeep.springaop.controller;

import com.pradeep.springaop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String test(){
        System.out.println("After AOP");
        String test = null;
        try {
            test =  userService.test("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }
}
