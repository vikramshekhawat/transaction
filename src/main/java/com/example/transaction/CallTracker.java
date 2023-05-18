package com.example.transaction;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CallTracker {
    @Pointcut("within(com..repo.*)")
    public void logMethodpointcut() {

    }


    @Around("logMethodpointcut()")
    public void logBeforeMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("executed before method call -"+proceedingJoinPoint.getSignature().getName());
        Object returnValue = proceedingJoinPoint.proceed();
        System.out.println(returnValue);
        System.out.println("executed After method call -"+proceedingJoinPoint.getSignature().getName());

    }


}
