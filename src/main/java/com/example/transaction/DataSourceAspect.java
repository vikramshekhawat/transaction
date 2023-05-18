package com.example.transaction;

import com.mysql.cj.jdbc.ConnectionImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.Connection;

@Component
@Aspect
public class DataSourceAspect {


    @Around("target(javax.sql.DataSource)")
    public Object logDataSourceConnectionInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("datasource tracker : " + proceedingJoinPoint.getSignature());
        Object returnValue = proceedingJoinPoint.proceed();
        if (returnValue instanceof Connection) {
            Connection con = (Connection) Proxy.newProxyInstance(ConnectionImpl.class.getClassLoader(), new Class[]{Connection.class}, new ConnectionInvocationHandler((Connection) returnValue));
            return con;
        }
        return returnValue;
    }
}
