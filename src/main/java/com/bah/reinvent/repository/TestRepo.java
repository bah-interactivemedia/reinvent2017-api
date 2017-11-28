package com.bah.reinvent.repository;

import com.bah.reinvent.model.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepo extends CrudRepository<Test, String>{
    Test findByTestId(String testId);
}
