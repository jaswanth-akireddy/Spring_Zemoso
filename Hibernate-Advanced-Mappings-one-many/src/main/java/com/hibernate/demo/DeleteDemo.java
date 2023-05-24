package com.hibernate.demo;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating a new student object..");


            session.beginTransaction();

            int theId =1;
            Instructor tempInstructor = session.get(Instructor.class,theId);

            System.out.println("Found instructor: "+tempInstructor);

            if(tempInstructor!=null){
                System.out.println("Deleting: "+tempInstructor);

                session.delete(tempInstructor);
            }

            session.getTransaction().commit();

            System.out.println("Committed and Done");

        }
        finally {
            factory.close();
        }

    }
}