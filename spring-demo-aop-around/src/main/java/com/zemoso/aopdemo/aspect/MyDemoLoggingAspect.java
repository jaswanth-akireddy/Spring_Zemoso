package com.zemoso.aopdemo.aspect;

import com.zemoso.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.zemoso.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint)throws Throwable{

        //print method we are advising on
        //compute duration of program
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @Around on method: "+method);

        long begin = System.currentTimeMillis();

        Object result = theProceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("\n===>Duration: "+duration/1000.0+" seconds");

        return result;
    }


    @After("execution(* com.zemoso.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyAccountsAdvice(JoinPoint theJoinPoint){

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @After(finally) on method: "+method);


    }

    @AfterThrowing(
            pointcut ="execution(* com.zemoso.aopdemo.dao.AccountDAO.findAccounts(..))"
            ,throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint,Throwable theExc){

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @AfterThrowing on method: "+method);

        System.out.println("\n===> The Exception is: "+ theExc);
    }

    @AfterReturning(pointcut = "execution(* com.zemoso.aopdemo.dao.AccountDAO.findAccounts(..))"
    ,returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @AfterReturning on method: "+method);

        System.out.println("\n===>Result is: "+result);

        //Post process the data - modify
        convertAccountNamesToUpperCase(result);

        System.out.println("\n===>Result is: "+result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for(Account tempAccount: result){
            String theUpperName = tempAccount.getName().toUpperCase();

            tempAccount.setName(theUpperName);
        }

    }

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
