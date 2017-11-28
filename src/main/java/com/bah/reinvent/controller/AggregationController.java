package com.bah.reinvent.controller;

import com.bah.reinvent.model.StudentActivity;
import com.bah.reinvent.model.StudentAggregate;
import com.bah.reinvent.model.StudentAttrib;
import com.bah.reinvent.model.Test;
import com.bah.reinvent.repository.StudentAttribRepo;
import com.bah.reinvent.repository.StudentTestRepository;
import com.bah.reinvent.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/reports")
public class AggregationController {

    @Autowired
    StudentAttribRepo studentAttribRepo;
    @Autowired
    private StudentTestRepository studentTestRepository;
    @Autowired
    private TestRepo testRepo;


    @GetMapping(value="/class/{id}")
    public StudentAggregate StateAggregation(@PathVariable String id)
    {
        int bmiAvg = 0, bodyfatCalcAvg = 0, weightAvg = 0, heightInchesAvg = 0, heightFeetAvg = 0, calfSkinfoldAvg = 0, tricepSkinfoldAvg = 0;
        int totalSeconds=0, minAvg=0, secAvg=0, numCurlsAvg=0;

        List<StudentAttrib> attributes = studentAttribRepo.findByClassId(id);
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

        Iterable<StudentActivity> allTests = studentTestRepository.findAll();
        List<StudentActivity> testScores = new ArrayList<>();

        for(StudentActivity test : allTests) {
            Test temp = testRepo.findByTestId(test.getTestId());
            if (temp.getClassId().equals(id)) {
                testScores.add(test);
            } else {

            }
        }


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


