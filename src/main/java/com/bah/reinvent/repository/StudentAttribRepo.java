package com.bah.reinvent.repository;

import com.bah.reinvent.model.StudentAttrib;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface StudentAttribRepo extends CrudRepository<StudentAttrib, String>{
    List<StudentAttrib> findByStudentId(String id);

}
