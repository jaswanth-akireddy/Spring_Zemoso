package com.zemoso.aopdemo.dao;

import com.zemoso.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;

    private String serviceCode;

    public void addAccount(Account theAccount,boolean vipFlag){

        System.out.println(getClass()+ ": Doing my db work: adding an account");

    }

    public List<Account> findAccounts(){
        List<Account> myAccounts = new ArrayList<>();

        //create sample accounts and add to list
        Account temp1 = new Account("John","Silver");
        Account temp2 = new Account("Madhu","Platinum");
        Account temp3 = new Account("Luca","Gold");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }
    public boolean doWork(){
        System.out.println(getClass()+ ": Doing doWork()");
        return true;
    }

    public String getName() {
        System.out.println(getClass()+ ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+ ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+ ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+ ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
