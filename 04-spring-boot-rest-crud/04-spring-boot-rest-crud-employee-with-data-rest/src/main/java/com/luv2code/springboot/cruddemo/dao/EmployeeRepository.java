package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members") // change /employees to /members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // just change the entity type and primary key type and all the CRUD methods are available

    // that's it ... all methods are inherited from JpaRepository


    // now, the spring-boot-starter-data-rest dependency will automatically
    // expose the REST endpoints for the entity type specified in the JpaRepository

    // so, we don't need to create a controller for the entity type specified in the JpaRepository

    // ENDPOINTS:
    // GET /employees
    // GET /employees/{id}
    // POST /employees
    // PUT /employees
    // DELETE /employees/{id}
}
