package com.designpattern.interceptor;

public interface Interceptor {
    public Response intercept(TargetInvocation targetInvocation);
}
