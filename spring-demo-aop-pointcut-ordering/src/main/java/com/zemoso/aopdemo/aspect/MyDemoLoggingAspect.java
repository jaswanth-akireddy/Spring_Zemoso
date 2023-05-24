package com.zemoso.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {



    @Before("com.zemoso.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddaAccountAdvice() {

        System.out.println("\n===>>  Executing @Before advice on method() <<===");
    }




}
