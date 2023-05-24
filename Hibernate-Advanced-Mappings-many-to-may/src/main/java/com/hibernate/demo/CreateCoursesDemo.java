package com.hibernate.demo;

import com.hibernate.entity.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId =1;
            Instructor tempInstructor = session.get(Instructor.class,theId);

            Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
            Course tempCourse2 = new Course("The Pinball Masterclass");

            // add courses to instructor
            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            // save the courses
            session.save(tempCourse1);
            session.save(tempCourse2);


            session.getTransaction().commit();

            System.out.println("Committed and Done");

        }
        finally {
            session.close();
            factory.close();
        }

    }
}