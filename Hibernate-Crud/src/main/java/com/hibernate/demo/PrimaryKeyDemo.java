package com.hibernate.demo;

import com.test.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating a new student object..");
            Student tempStudent1 = new Student("Akshith","Public","Akshith@zemosolabs.com");
            Student tempStudent2 = new Student("Prasad","Static","Prasad@zemosolabs.com");
            Student tempStudent3 = new Student("bablu","voud","bablu@zemosolabs.com");


            session.beginTransaction();
            System.out.println("saving the student in db");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            session.getTransaction().commit();

            System.out.println("Committed and Done");
        }
        finally {
            factory.close();
        }
    }
}