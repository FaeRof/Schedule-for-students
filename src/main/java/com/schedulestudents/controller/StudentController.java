package com.schedulestudents.controller;

import com.schedulestudents.domain.dto.StudentDto;
import com.schedulestudents.service.StudentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("students") StudentDto studentDto){
        service.add(studentDto);
        return "redirect:/student/list";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") int id){
        service.deleteById(id);
        return "redirect:/student/list";
    }
}
