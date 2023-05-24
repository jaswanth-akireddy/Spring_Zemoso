package com.hibernate.demo;

import com.hibernate.entity.*;
import com.hibernate.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class CreateCourseAndReviewsDemo {
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

            Course tempCourse = new Course("Pacman -How to score High");

            tempCourse.addReview(new Review("Great trick to score high"));
            tempCourse.addReview(new Review("Cool trick"));
            tempCourse.addReview(new Review("Not so good"));

            System.out.println("Saving the course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);

            session.getTransaction().commit();

            System.out.println("Committed and Done");

        }
        finally {
            session.close();
            factory.close();
        }

    }
}