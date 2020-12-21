package com.pradeep.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String test(String st) throws Exception{
        return "Test Ok";
    }
}
