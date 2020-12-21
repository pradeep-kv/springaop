package com.pradeep.springaop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class LogAspect {

    @Pointcut("execution (* com.pradeep..*(..))")
    public void exePackageWildcard(){}

    @Pointcut("execution(* com.pradeep.springaop.service..*(..)))")
    public void exePackageServiceWildcard(){}

    @Pointcut("execution(* com.pradeep.springaop.model..*(..))")
    private void exePackageModelWildcard(){}

    @Pointcut("exePackageWildcard() && (! exePackageModelWildcard())")
    private void exePackageWithOutModelWildcard() {}

    @Before(value = "exePackageWithOutModelWildcard()")
    public void beforeTest(){
        System.out.println("Test Before LogAspect AOP working");
    }

    @After(value = "exePackageServiceWildcard()")
    public void Aftertest(){
        System.out.println("Test After LogAspect AOP working");
    }
}
