package com.pradeep.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MonitoringAspect {

    @Before(value = "com.pradeep.springaop.aspect.LogAspect.exePackageServiceWildcard()")
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

    @AfterReturning(value = "com.pradeep.springaop.aspect.LogAspect.exePackageServiceWildcard()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, String result){
        String signature = joinPoint.getSignature().toShortString();
        System.out.println("Test After Returning MonitoringAspect AOP working with order for method : \n" + signature);
        System.out.println("After Returning MonitoringAspect AOP  :: Result ::" + result);
    }

    @AfterThrowing(value = "com.pradeep.springaop.aspect.LogAspect.exePackageServiceWildcard()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable exception){
        String signature = joinPoint.getSignature().toShortString();
        System.out.println("Test After Throwing MonitoringAspect AOP working with order for method : \n" + signature);
        System.out.println("After Throwing MonitoringAspect AOP :: Exception class :: " + exception.getClass());
    }

    @Around(value = "com.pradeep.springaop.aspect.LogAspect.exePackageServiceWildcard()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String signature = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("Test Around MonitoringAspect AOP : \n" + signature);
        Object result;
        try{
            result = proceedingJoinPoint.proceed();
        }catch (Exception e){
            System.out.println("Around MonitoringAspect AOP :: Exception class :: " + e.getClass());
            throw e;
        }
        System.out.println("Test Around MonitoringAspect AOP :: Result ::" + result);
        return result;
    }
}
