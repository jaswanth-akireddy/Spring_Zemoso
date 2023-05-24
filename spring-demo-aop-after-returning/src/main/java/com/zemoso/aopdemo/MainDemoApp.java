package com.zemoso.aopdemo;

import com.zemoso.aopdemo.dao.AccountDAO;
import com.zemoso.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO theAccountDAO =context.getBean("accountDAO",AccountDAO.class);

        MembershipDAO theMembershipDAO =context.getBean("membershipDAO",MembershipDAO.class);

        Account myAccount = new Account();
        myAccount.setName("Lokesh");
        myAccount.setLevel("Platinum");

        theAccountDAO.addAccount(myAccount,true);
        theAccountDAO.doWork();
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("gold");

        String name =theAccountDAO.getName();
        String code =theAccountDAO.getServiceCode();

        theMembershipDAO.addMembership();
        theMembershipDAO.goToSleep();

        context.close();
    }
}
