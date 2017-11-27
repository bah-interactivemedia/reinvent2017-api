package com.bah.reinvent.controller;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.bah.reinvent.model.Student;
import com.bah.reinvent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ControllerV1 {

    @Autowired
    private StudentRepository repo;

    private AmazonDynamoDBClient dynamoDBClient;



    @GetMapping(value = "/hello")
    public ResponseEntity helloWorld(){

        return new ResponseEntity("Hello World from Spring Boot!", HttpStatus.OK);

    }

    @GetMapping(value = "/test")
    public Iterable<Student> getStudent(){

          return repo.findAll();
//        return repo.findByLastName("Vargas");
    }

    @PostMapping(value= "/test/post")
    public Student postTest(@RequestBody Student student){
        try {
            repo.save(student);
        } catch (Exception e){
            System.out.println("Something went wrong");
        }
        return student;
    }

}
