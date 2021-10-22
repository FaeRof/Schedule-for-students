package com.schedulestudents.controller;

import com.schedulestudents.domain.dto.StudentDto;
import com.schedulestudents.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }


    @GetMapping("/list")
    public ResponseEntity<List<StudentDto>> getAll(){
        List<StudentDto> students = service.getAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        StudentDto studentDto = new StudentDto();
        model.addAttribute("students", studentDto);
        return "student_form";
    }

    @PostMapping("/save")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
        service.add(studentDto);
        return ResponseEntity.ok(studentDto);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") int id){
        service.deleteById(id);
        return "redirect:/student/list";
    }
}
