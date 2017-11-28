package com.bah.reinvent.controller;

import com.bah.reinvent.model.Student;
import com.bah.reinvent.model.StudentActivity;
import com.bah.reinvent.model.StudentAggregate;
import com.bah.reinvent.model.StudentAttrib;
import com.bah.reinvent.repository.StudentAttribRepo;
import com.bah.reinvent.repository.StudentRepository;
import com.bah.reinvent.repository.StudentTestRepository;
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
    @Autowired
    private StudentTestRepository studentTestRepository;


    @GetMapping()
    public Iterable<Student> getStudents() {
        return repo.findAll();
    }

    @PostMapping()
    public Student createStudent(@RequestBody Student student) throws Exception {
        try {
            repo.save(student);
        } catch (Exception e) {
            throw new Exception("Unable to save data");
        }
        return student;
    }

    @GetMapping(value = "/{id}")
    public Student getStudent(@PathVariable String id) {
        return repo.findByStudentId(id);
    }

    @PostMapping(value = "/{id}/attributes")
    public StudentAttrib addAttributes(@RequestBody StudentAttrib attributes) {
        studentAttribRepo.save(attributes);
        return attributes;
    }

    @GetMapping(value = "/{id}/aggregate")
    public StudentAggregate individualAggregate(@PathVariable String id) {
        //Let's start with physical attributes

        int bmiAvg = 0, bodyfatCalcAvg = 0, weightAvg = 0, heightInchesAvg = 0, heightFeetAvg = 0, calfSkinfoldAvg = 0, tricepSkinfoldAvg = 0;
        int totalSeconds=0, minAvg=0, secAvg=0, numCurlsAvg=0;

        List<StudentAttrib> attributes = studentAttribRepo.findByStudentId(id);
        int attrTotal = attributes.size();

        for (StudentAttrib sa : attributes) {
            bmiAvg += Integer.parseInt(sa.getStudentAttribBmi());
            bodyfatCalcAvg += Integer.parseInt(sa.getStudentAttribPercentBodyfatCalculated());
            weightAvg += Integer.parseInt(sa.getStudentAttribWeightPounds());
            heightInchesAvg += Integer.parseInt(sa.getStudentAttribHeightInches());
            heightFeetAvg += Integer.parseInt(sa.getStudentAttribHeightInches());
            calfSkinfoldAvg += Integer.parseInt(sa.getStudentAttribCalfSkinfold());
            tricepSkinfoldAvg += Integer.parseInt(sa.getStudentAttribTricepSkinfold());
        }

        bmiAvg = bmiAvg / attrTotal;
        bodyfatCalcAvg = bodyfatCalcAvg / attrTotal;
        weightAvg = weightAvg / attrTotal;
        heightFeetAvg = heightInchesAvg / attrTotal;
        calfSkinfoldAvg = calfSkinfoldAvg / attrTotal;
        tricepSkinfoldAvg = tricepSkinfoldAvg / attrTotal;
        heightInchesAvg = heightInchesAvg / attrTotal;

        List<StudentActivity> testScores = studentTestRepository.findByStudentId(id);
        int testTotal = testScores.size();

        for(StudentActivity scores : testScores) {

            totalSeconds= (Integer.parseInt(scores.getStudentTestActivity2FieldMinutes()) * 60) +
                Integer.parseInt(scores.getStudentTestActivity2FieldSeconds());

            numCurlsAvg = Integer.parseInt(scores.getStudentTestActivity1FieldTotal());
        }

        // avg sec
        minAvg = (totalSeconds/testTotal)/60;
        secAvg = (totalSeconds/testTotal)%60;
        numCurlsAvg = numCurlsAvg/testTotal;



        StudentAggregate aggregatedData = new StudentAggregate(attributes, testScores, bmiAvg, bodyfatCalcAvg, weightAvg,
                heightFeetAvg, heightInchesAvg, calfSkinfoldAvg, tricepSkinfoldAvg, minAvg, secAvg, numCurlsAvg);

        return aggregatedData;
    }


}
