package com.hibernate.demo;
import com.test.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating a new student object..");

            Student tempStudent = new Student("Daffy","Duck","Daffy@zemosolabs.com");

            session.beginTransaction();
            System.out.println("saving the student in db");
            System.out.println(tempStudent);
            session.save(tempStudent);

            session.getTransaction().commit();

            //To retrieve from db
            System.out.println("Saved student Id is "+ tempStudent.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Getting student with id "+ tempStudent.getId());

            Student myStudent = session.get(Student.class,tempStudent.getId());
            System.out.println("Get complete "+myStudent);
            session.getTransaction().commit();
            System.out.println("Committed and Done");

        }
        finally {
            factory.close();
        }

    }
}