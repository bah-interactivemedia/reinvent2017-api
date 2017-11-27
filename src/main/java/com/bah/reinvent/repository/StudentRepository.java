package com.bah.reinvent.repository;

import com.bah.reinvent.model.Student;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface StudentRepository extends CrudRepository<Student, Integer> {
}