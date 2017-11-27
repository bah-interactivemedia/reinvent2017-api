package com.bah.reinvent.controller;

import com.bah.reinvent.model.StudentActivity;
import com.bah.reinvent.repository.StudentTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tests")
public class StudentTestController {

    @Autowired
    private StudentTestRepository studentTestRepository;

    @GetMapping()
    public Iterable<StudentActivity> getAllResults()
    {
       return studentTestRepository.findAll();
    }

    @PostMapping(value = "/{testId}/{studentId}")
    public List<StudentActivity> inputResults(@PathVariable String testId, @PathVariable String studentId){

//        Need to find the doc pertaining to this particular test and student
        return studentTestRepository.findByStudentIdAndTestId(studentId, testId);

    }


}
