package com.designpattern.interceptor;

public class AuditInterceptor implements Interceptor{
    @Override
    public Response intercept(TargetInvocation targetInvocation) {
        System.out.println("Audit Succeeded Begin");
        Response response = targetInvocation.invoke();
        System.out.println("Audit Succeeded End");
        return response;
    }
}
