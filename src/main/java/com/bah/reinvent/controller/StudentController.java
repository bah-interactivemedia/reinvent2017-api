package com.bah.reinvent.controller;

import com.bah.reinvent.model.Student;
import com.bah.reinvent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "students")
public class StudentController {

    @Autowired
    private StudentRepository repo;


    @GetMapping()
    public Iterable<Student> getStudents(){
          return repo.findAll();
    }

    @PostMapping()
    public Student createStudent(@RequestBody Student student) throws Exception {
        try {
            repo.save(student);
        } catch (Exception e){
            throw new Exception("Unable to save data");
        }
        return student;
    }


}
