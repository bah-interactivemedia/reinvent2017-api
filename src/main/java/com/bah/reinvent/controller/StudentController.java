package com.bah.reinvent.controller;

import com.bah.reinvent.model.Student;
import com.bah.reinvent.model.StudentAggregate;
import com.bah.reinvent.model.StudentAttrib;
import com.bah.reinvent.repository.StudentAttribRepo;
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
    @Autowired
    private StudentAttribRepo studentAttribRepo;


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

    @GetMapping(value="/{id}")
    public Student getStudent(@PathVariable String id) {
        return repo.findByStudentId(id);
    }

    @PostMapping(value="/{id}/attributes")
    public StudentAttrib addAttributes(@RequestBody StudentAttrib attributes)
    {
        studentAttribRepo.save(attributes);
        return attributes;
    }

    @GetMapping(value="/{id}/aggregate")
    public StudentAggregate individualAggregate(@PathVariable String id) {
        //Let's start with physical attributes

        int bmiAvg=0, bodyfatCalcAvg=0, weightAvg=0, heightInchesAvg=0, heightFeetAvg=0, calfSkinfoldAvg=0, tricepSkinfoldAvg = 0;


        List<StudentAttrib> attributes = studentAttribRepo.findByStudentId(id);
        int total = attributes.size();

        for (StudentAttrib sa : attributes){
            bmiAvg += Integer.parseInt(sa.getStudentAttribBmi());
            bodyfatCalcAvg += Integer.parseInt(sa.getStudentAttribPercentBodyfatCalculated());
            weightAvg += Integer.parseInt(sa.getStudentAttribWeightPounds());
            heightInchesAvg += Integer.parseInt(sa.getStudentAttribHeightInches());
            heightFeetAvg += Integer.parseInt(sa.getStudentAttribHeightInches());
            calfSkinfoldAvg += Integer.parseInt(sa.getStudentAttribCalfSkinfold());
            tricepSkinfoldAvg += Integer.parseInt(sa.getStudentAttribTricepSkinfold());
        }

        bmiAvg = bmiAvg/total;
        bodyfatCalcAvg = bodyfatCalcAvg/total;
        weightAvg = weightAvg/total;
        heightFeetAvg = heightInchesAvg/total;
        calfSkinfoldAvg = calfSkinfoldAvg/total;
        tricepSkinfoldAvg = tricepSkinfoldAvg/total;
        heightInchesAvg = heightInchesAvg/total;

        StudentAggregate aggregatedData = new StudentAggregate(attributes, bmiAvg, bodyfatCalcAvg, weightAvg, heightFeetAvg, heightInchesAvg, calfSkinfoldAvg, tricepSkinfoldAvg);

        return aggregatedData;



    }


}
