package com.hibernate.demo;
import com.test.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        SessionFactory sf=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session=sf.getCurrentSession();

        int studentid=sc.nextInt();
        String fname=sc.nextLine();
        session= sf.getCurrentSession();
        session.beginTransaction();
        Student stu =session.get(Student.class,studentid);
        stu.setFirstName(fname);
        session.getTransaction().commit();
        session.close();
    }
}
