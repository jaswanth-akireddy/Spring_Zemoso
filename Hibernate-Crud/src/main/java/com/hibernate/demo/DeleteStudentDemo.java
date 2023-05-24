package com.hibernate.demo;

import com.test.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

//            System.out.println("Deleting student :"+ myStudent);
//            session.delete(myStudent);

            System.out.println("Deleting Student id=2");
            session.createQuery("delete from Student where id=1").executeUpdate();
//            session.createQuery("delete from Student where id=2").executeUpdate();
//            session.createQuery("delete from Student where id=3").executeUpdate();
//            session.createQuery("delete from Student where id=4").executeUpdate();
//            session.createQuery("delete from Student where id=5").executeUpdate();
//            session.createQuery("delete from Student where id=6").executeUpdate();
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }
}