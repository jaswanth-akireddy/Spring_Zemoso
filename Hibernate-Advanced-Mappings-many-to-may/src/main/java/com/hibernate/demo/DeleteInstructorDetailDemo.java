package com.hibernate.demo;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class DeleteInstructorDetailDemo{
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

            int theId =4;

            InstructorDetail tempInstructorDetail
                    = session.get(InstructorDetail.class,theId);
            System.out.println("tempInstructorDetail: "+ tempInstructorDetail);

            System.out.println("The associated instructor is: "+ tempInstructorDetail.getInstructor());

            //to delete instructor detail

            System.out.println("Deleting tempInstructorDetail: "+ tempInstructorDetail);



            session.delete(tempInstructorDetail);

            session.getTransaction().commit();

            System.out.println("Committed and Done");

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            //to handle connection leak
            session.close();
            factory.close();
        }

    }
}