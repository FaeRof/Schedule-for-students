package com.schedulestudents.controller;

import com.schedulestudents.domain.dto.StudentDto;
import com.schedulestudents.service.StudentService;
import org.springframework.http.HttpStatus;
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


    @PostMapping("/save")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
        service.add(studentDto);
        return ResponseEntity.ok(studentDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
