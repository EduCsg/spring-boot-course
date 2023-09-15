package com.springbootrestcrud.demo.rest;

import com.springbootrestcrud.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // declares the list at class scope
    private List<Student> theStudents;

    // define @PostConstructor to load the student data only once
    // faz com que a ação só seja executada APÓS o spring instanciar todos os beans.
    // caso contrário, o spring não vai conseguir injetar nada dentro de studentsList por nao existir ainda
    @PostConstruct
    public void loadData() {
        // initialize theStudents list as an empty array
        theStudents = new ArrayList<>();

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
        return theStudents.get(studentId);
    }
}
