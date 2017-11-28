package com.bah.reinvent.controller;

import com.bah.reinvent.model.StudentActivity;
import com.bah.reinvent.repository.StudentTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.http.HTTPException;
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

    @PostMapping(value = "/{testId}/{studentId}/curls")
    public StudentActivity inputResultsCurls(@PathVariable String testId, @PathVariable String studentId, @RequestBody StudentActivity body){

        StudentActivity saDoc = null;
//        Need to find the doc pertaining to this particular test and student
        try {
            saDoc = studentTestRepository.findByStudentIdAndTestId(studentId, testId);
        }
        catch(HTTPException e)
        {
          if (e.getStatusCode() == 404){
              studentTestRepository.save(body);
          }
        }
        saDoc.setStudentTestActivity1FieldTotal(body.getStudentTestActivity1FieldTotal());

        return saDoc;
    }

    @PostMapping(value = "/{testId}/{studentId}/mile")
    public StudentActivity inputResultsMile(@PathVariable String testId, @PathVariable String studentId, @RequestBody StudentActivity body){

        StudentActivity saDoc = null;
//        Need to find the doc pertaining to this particular test and student
        try {
            saDoc = studentTestRepository.findByStudentIdAndTestId(studentId, testId);
        }
        catch(HTTPException e)
        {
            if (e.getStatusCode() == 404){
                studentTestRepository.save(body);
            }
        }
        saDoc.setStudentTestActivity2FieldMinutes(body.getStudentTestActivity2FieldMinutes());
        saDoc.setStudentTestActivity2FieldSeconds(body.getStudentTestActivity2FieldSeconds());

        return saDoc;
    }


}
