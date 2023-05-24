package com.zemoso.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution( * com.zemoso.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution( * com.zemoso.aopdemo.dao.*.get*(..))")
    private void forGetters(){}

    @Pointcut("execution( * com.zemoso.aopdemo.dao.*.set*(..))")
    private void forSetters(){}

    @Pointcut("forDaoPackage() && !(forGetters() || forSetters())")
    private void forDaoPackageNoGetterSetter(){}


    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddaAccountAdvice() {

        System.out.println("\n===>>  Executing @Before advice on method() <<===");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n ==>> Performing API analytics");
    }

}
