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
import java.util.logging.Logger;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.zemoso.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint)throws Throwable{

        //print method we are advising on
        //compute duration of program
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n===> Executing @Around on method: "+method);

        long begin = System.currentTimeMillis();

        Object result = null;
        try {
           result = theProceedingJoinPoint.proceed();
        }
        catch (Exception e){
           myLogger.warning(e.getMessage());

           throw e;
           //result = "Major accident!But no worries,"+"We can handle the situation";
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;

        myLogger.info("\n===>Duration: "+duration/1000.0+" seconds");

        return result;
    }


    @After("execution(* com.zemoso.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyAccountsAdvice(JoinPoint theJoinPoint){

        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n===> Executing @After(finally) on method: "+method);


    }

    @AfterThrowing(
            pointcut ="execution(* com.zemoso.aopdemo.dao.AccountDAO.findAccounts(..))"
            ,throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint,Throwable theExc){

        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n===> Executing @AfterThrowing on method: "+method);

        myLogger.info("\n===> The Exception is: "+ theExc);
    }

    @AfterReturning(pointcut = "execution(* com.zemoso.aopdemo.dao.AccountDAO.findAccounts(..))"
    ,returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){

        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n===> Executing @AfterReturning on method: "+method);

        myLogger.info("\n===>Result is: "+result);

        //Post process the data - modify
        convertAccountNamesToUpperCase(result);

        myLogger.info("\n===>Result is: "+result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for(Account tempAccount: result){
            String theUpperName = tempAccount.getName().toUpperCase();

            tempAccount.setName(theUpperName);
        }

    }

    @Before("com.zemoso.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddaAccountAdvice(JoinPoint theJoinPoint) {

        myLogger.info("\n===>>  Executing @Before advice on method() <<===");
        //display method signature
        MethodSignature methodSignature
                = (MethodSignature) theJoinPoint.getSignature();

        myLogger.info("Method: "+ methodSignature);

        //display method arguments
        Object[] args = theJoinPoint.getArgs();

        for(Object tempArg:args)
        {
            myLogger.info(tempArg.toString());
            if(tempArg instanceof Account ){
                Account theAccount = (Account)tempArg;
                myLogger.info("Account name: "+ theAccount.getName());
                myLogger.info("Account level: "+ theAccount.getLevel());
            }
        }
    }

}
