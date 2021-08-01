package com.example.design.invoke.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangyihao
 * @ClassName DynamicInvoke
 * @date 2021/6/30 10:07
 * @Description
 */
public class DynamicInvoke implements InvocationHandler {

    private Object target;

    public DynamicInvoke(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(target, args);
        System.out.println("增强的方法");

        return invoke;
    }

    public Object getProxy(){

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);

    }

}
