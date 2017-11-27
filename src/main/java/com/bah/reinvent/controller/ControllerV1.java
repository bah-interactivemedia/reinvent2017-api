package com.bah.reinvent.controller;

import com.bah.reinvent.model.Student;
import com.bah.reinvent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class ControllerV1 {

    @Autowired
    private StudentRepository repo;



    @GetMapping(value = "/hello")
    public ResponseEntity helloWorld(){

        return new ResponseEntity("Hello World from Spring Boot!", HttpStatus.OK);

    }

    @GetMapping(value = "/test")
    public Iterable<Student> getStudent(){

          return repo.findAll();
//        return repo.findByLastName("Vargas");
    }
}
