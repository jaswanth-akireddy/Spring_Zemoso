package com.hibernate.demo;

import com.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating a new student object..");


            Instructor tempInstructor = new Instructor("Susan","Public","susan@zemosolabs.com");

            InstructorDetail tempInstructorDetail
                    = new InstructorDetail("https://www.linkedin.com","Gamer");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            System.out.println("Saving instructor "+ tempInstructor);
            session.save(tempInstructor);

            session.getTransaction().commit();

            System.out.println("Committed and Done");

        }
        finally {
            session.close();
            factory.close();
        }

    }
}