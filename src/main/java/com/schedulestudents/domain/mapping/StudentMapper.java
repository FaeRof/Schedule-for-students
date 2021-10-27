package com.schedulestudents.domain.mapping;

import com.schedulestudents.domain.dbo.StudentEntity;
import com.schedulestudents.domain.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudentMapper {

    private final ModelMapper mapper;

    public List<StudentDto> fromListDbo(List<StudentEntity> studentEntityList){
        return studentEntityList.stream()
                .map(this::fromDbo)
                .collect(Collectors.toList());
    }

    public StudentDto fromDbo(StudentEntity studentEntity){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(studentEntity, StudentDto.class);
    }
    public StudentEntity toDbo(StudentDto studentDto){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(studentDto, StudentEntity.class);
    }
}
