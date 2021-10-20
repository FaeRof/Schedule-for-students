package com.schedulestudents.controller;

import com.schedulestudents.domain.dto.StudentDto;
import com.schedulestudents.service.StudentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }


    @GetMapping("/list")
    public String getAll(Model model){
        List<StudentDto> students = service.getAll();
        model.addAttribute("students",students);
        return "list_students";
    }
}
