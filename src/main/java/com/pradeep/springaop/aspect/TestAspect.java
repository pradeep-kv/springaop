package com.pradeep.springaop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class TestAspect {

    @Before(value = "execution (* com.pradeep..*())")
    public void beforeTest(){
        System.out.println("Test Before AOP working");
    }

    @After(value = "execution (* com.pradeep.springaop.service..*())")
    public void Aftertest(){
        System.out.println("Test After AOP working");
    }
}
