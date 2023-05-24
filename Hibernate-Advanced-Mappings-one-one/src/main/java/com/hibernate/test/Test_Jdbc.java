package com.hibernate.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test_Jdbc {
    public static void main(String[] args) {
        String jdbcurl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSl=false";
        String user="root";
        String password="";
        try{
            System.out.println("Connecting to database:"+jdbcurl);
            Connection myconn= DriverManager.getConnection(jdbcurl,user,password);
            System.out.println("Connection successful");
        }
        catch (Exception e ){
            System.out.println(e);
        }
    }
}
