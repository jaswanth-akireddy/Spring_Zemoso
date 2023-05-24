package com.zemoso.aopdemo.dao;

import com.zemoso.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(Account theAccount,boolean vipFlag){

        System.out.println(getClass()+ ": Doing my db work: adding an account");

    }
    public boolean doWork(){
        System.out.println(getClass()+ ": Doing doWork()");

        return true;
    }
}
