package com.hibernate.entity;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;

    String studentName;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    DepartmentEntity department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                '}';
    }

    public StudentEntity(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
