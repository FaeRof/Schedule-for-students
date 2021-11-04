package com.schedulestudents.service;

import com.schedulestudents.domain.dbo.StudentEntity;
import com.schedulestudents.domain.dto.StudentDto;
import com.schedulestudents.domain.mapping.StudentMapper;
import com.schedulestudents.repository.StudentRepository;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper mapper;

    public StudentService(StudentRepository repository, StudentMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<StudentDto> getAll(){
        var studentEntities = repository.findAll();
        var student = new ArrayList<StudentDto>();
        studentEntities.forEach(entity -> student.add(mapper.fromDbo(entity)));
        return student;
    }

    public void add(StudentDto studentDto){
        repository.save(mapper.toDbo(studentDto));
    }

    public StudentEntity updateStudentById(StudentEntity student, Integer id){
        repository.findById(id);
        student.setFirstName(student.getFirstName());
        student.setLastName(student.getLastName());
        student.setBirthDate(student.getBirthDate());
        student.setAddress(student.getAddress());
        student.setTelephone(student.getTelephone());

        return repository.save(student);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }
}
