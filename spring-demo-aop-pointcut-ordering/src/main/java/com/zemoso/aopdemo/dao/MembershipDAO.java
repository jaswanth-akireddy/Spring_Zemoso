package com.zemoso.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public boolean addMembership(){

        System.out.println(getClass()+ ": Doing my db work: adding membership account");

        return true;

    }
    public void goToSleep(){
        System.out.println(getClass()+ ": I am going to sleep");
    }
}
