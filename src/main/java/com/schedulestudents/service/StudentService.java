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

//    public String updateStudent(Integer id, StudentDto studentDto){
//        List<StudentEntity> student = new ArrayList<>();
//        for (int i =0; i<student.size(); i++){
//            if (student.get(i).getId().equals(id)){
//                student.get(i).setFirstName(studentDto.getFirstName());
//                student.get(i).setLastName(studentDto.getLastName());
//                student.get(i).setBirthDate(studentDto.getBirthDate());
//                student.get(i).setAddress(studentDto.getAddress());
//                student.get(i).setTelephone(studentDto.getTelephone());
//            }
//        }
//
//    }

    public void deleteById(int id){
        repository.deleteById(id);
    }
}
