package com.designpattern.interceptor;

public class LogInterceptor implements Interceptor {
    @Override
    public Response intercept(TargetInvocation targetInvocation) {
        System.out.println("Logging Begin");
        Response response = targetInvocation.invoke();
        System.out.println("Logging End");
        return response;
    }
}

