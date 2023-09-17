package com.springbootrestcrud.demo.rest;

import com.springbootrestcrud.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // declares the list at class scope
    private final List<Student> theStudents = new ArrayList<>();

    // define @PostConstructor to load the student data only once
    // faz com que a ação só seja executada APÓS o spring instanciar todos os beans.
    // caso contrário, o spring não vai conseguir injetar nada dentro de studentsList por nao existir ainda
    @PostConstruct
    public void loadData() {
        // populate the theStudents list at class scope
        theStudents.add(new Student("Eduardo", "Casagrande"));
        theStudents.add(new Student("Estudante", "02"));
        theStudents.add(new Student("Estudante", "03"));
    }

    // endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {

        // just returns the list from class scope
        return theStudents;
    }

    // define endpoint for "/students/{studentId}" -> Return student at index in list
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // return the student at index {studentId}

        if((studentId > theStudents.size() - 1) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id " + studentId + " not founded!");
        }

        return theStudents.get(studentId);
    }

    // add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

        // Create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return a ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

        // Create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Sorry, an unexpected error occurred!");
        error.setTimeStamp(System.currentTimeMillis());
        
        // return a ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}