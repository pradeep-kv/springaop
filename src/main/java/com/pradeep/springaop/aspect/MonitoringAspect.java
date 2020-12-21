package com.pradeep.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MonitoringAspect {

    @Before(value = "com.pradeep.springaop.aspect.LogAspect.exePackageWildcard()")
    public void beforeTest(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Test Before MonitoringAspect AOP working with order for method : \n" + signature);

        Object[] argObj = joinPoint.getArgs();
        System.out.println("Method Args are ::");
        for (Object obj: argObj) {
            System.out.println(obj);
        }
    }

    @After(value = "com.pradeep.springaop.aspect.LogAspect.exePackageServiceWildcard()")
    public void Aftertest(){
        System.out.println("Test After MonitoringAspect AOP working with order");
    }
}
