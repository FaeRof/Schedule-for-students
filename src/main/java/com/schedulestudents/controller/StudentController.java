package com.schedulestudents.controller;

import com.schedulestudents.domain.dbo.StudentEntity;
import com.schedulestudents.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StudentController {
    private final StudentRepository student;

    public StudentController(StudentRepository student) {
        this.student = student;
    }

    @GetMapping("/student")
    public String showStudentList(Map<String, Object> model){
        StudentEntity studentEntity = new StudentEntity();
        return "student";
    }
}
