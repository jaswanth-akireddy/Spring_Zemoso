package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.entity.*;

public class DeleteCourseDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId =10;
            Course tempCourse = session.get(Course.class,theId);
            System.out.println("Deleting Course: "+tempCourse);

            session.delete(tempCourse);

            session.getTransaction().commit();

            System.out.println("Committed and Done");

        }
        finally {
            session.close();
            factory.close();
        }

    }
}