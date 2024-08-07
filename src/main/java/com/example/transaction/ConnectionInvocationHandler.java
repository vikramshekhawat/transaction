package com.example.transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class ConnectionInvocationHandler implements InvocationHandler {

    private Connection connection;

    public ConnectionInvocationHandler(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(method.getName().contains("commit")||method.getName().contains("rollback")||method.getName().contains("close")){
            System.out.println("Fork-2 print connection trace --" + method.toGenericString());
        }

        Object invoke = method.invoke(connection, args);
        return invoke;
    }
}
