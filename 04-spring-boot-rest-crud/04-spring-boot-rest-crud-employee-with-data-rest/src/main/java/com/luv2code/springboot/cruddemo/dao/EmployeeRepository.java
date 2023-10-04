package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // just change the entity type and primary key type and all the CRUD methods are available
    
    // that's it ... all methods are inherited from JpaRepository
}
