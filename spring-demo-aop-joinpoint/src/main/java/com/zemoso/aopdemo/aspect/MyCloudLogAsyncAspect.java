package com.zemoso.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.zemoso.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void logCloudAsync(){
        System.out.println("\n ==>> Loggin to cloud in async fashion");
    }

}
