package com.designpattern.interceptor;

public class InterceptorDemo {

    public static void main(String[] args) {
        TargetInvocation targetInvocation = new TargetInvocation();
        targetInvocation.addInterceptor(new LogInterceptor());
        targetInvocation.addInterceptor(new AuditInterceptor());
        targetInvocation.setRequest(new Request());
        targetInvocation.setTarget(request-> {
            System.out.println("execute target");
            return new Response();
        });
        targetInvocation.invoke();
    }
}
