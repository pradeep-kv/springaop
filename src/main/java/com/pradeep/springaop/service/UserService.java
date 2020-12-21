package com.pradeep.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String test(String st, boolean flag) throws Exception{
        if(flag){
            throw new NullPointerException();
        }
        return "Test Ok";
    }
}
