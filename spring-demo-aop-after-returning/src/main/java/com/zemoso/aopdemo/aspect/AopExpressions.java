package com.zemoso.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class AopExpressions {

    @Pointcut("execution( * com.zemoso.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution( * com.zemoso.aopdemo.dao.*.get*(..))")
    public void forGetters(){}

    @Pointcut("execution( * com.zemoso.aopdemo.dao.*.set*(..))")
    public void forSetters(){}

    @Pointcut("forDaoPackage() && !(forGetters() || forSetters())")
    public void forDaoPackageNoGetterSetter(){}

}
