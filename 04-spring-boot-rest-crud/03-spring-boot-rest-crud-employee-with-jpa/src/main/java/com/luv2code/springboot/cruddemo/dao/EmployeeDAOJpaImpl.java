package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entity manager
    private final EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get results list
        // noinspection UnnecessaryLocalVariable
        List<Employee> employees = theQuery.getResultList();

        // returns the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // get employee
        @SuppressWarnings("UnnecessaryLocalVariable")
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // save employee
        // MERGE -> if id == 0, insert/save;
        //                  Else, update;
        @SuppressWarnings("UnnecessaryLocalVariable")
        Employee dbEmployee = entityManager.merge(theEmployee);

        // return the dbEmployee (ID from the database)
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // find by id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // remove employee
        entityManager.remove(theEmployee);
    }
}
