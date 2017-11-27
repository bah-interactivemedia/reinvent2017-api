package com.bah.reinvent.repository;

import com.bah.reinvent.model.StudentActivity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface StudentTestRepository extends CrudRepository<StudentActivity, Integer> {
    List<StudentActivity> findByStudentIdAndTestId(String studentID, String testId );
}
