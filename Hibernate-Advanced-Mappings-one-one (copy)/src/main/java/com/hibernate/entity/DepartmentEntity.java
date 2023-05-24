package com.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="department_id")
    int id;
    @Column(name ="department_name")
    String name;
    @OneToMany(cascade = CascadeType.ALL)
    StudentEntity student;


    public DepartmentEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
