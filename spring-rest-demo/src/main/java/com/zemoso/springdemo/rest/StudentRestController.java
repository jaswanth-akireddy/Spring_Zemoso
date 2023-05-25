package com.zemoso.springdemo.rest;

import com.zemoso.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
       theStudents = new ArrayList<>();

        theStudents.add(new Student("Sai", "lokesh"));
        theStudents.add(new Student("Arjun", "Ganesh"));
        theStudents.add(new Student("Shashi", "Bairu"));

    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;

    }

    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId) {

        if(studentId>=theStudents.size() || studentId<0){
            throw new StudentNotFoundException("Student id not found-"+studentId);
        }

        return theStudents.get(studentId);
    }


}
