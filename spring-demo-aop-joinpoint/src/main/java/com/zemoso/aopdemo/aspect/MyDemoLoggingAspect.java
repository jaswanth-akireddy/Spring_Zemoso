package com.zemoso.aopdemo.aspect;

import com.zemoso.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.zemoso.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddaAccountAdvice(JoinPoint theJoinPoint) {

        System.out.println("\n===>>  Executing @Before advice on method() <<===");
        //display method signature
        MethodSignature methodSignature
                = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: "+ methodSignature);

        //display method arguments
        Object[] args = theJoinPoint.getArgs();

        for(Object tempArg:args)
        {
            System.out.println(tempArg);
            if(tempArg instanceof Account ){
                Account theAccount = (Account)tempArg;
                System.out.println("Account name: "+ theAccount.getName());
                System.out.println("Account level: "+ theAccount.getLevel());
            }
        }
    }


}
