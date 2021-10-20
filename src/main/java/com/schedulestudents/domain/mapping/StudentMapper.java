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

    public List<StudentDto> fromListDbo(List<StudentEntity> authorEntityList){
        return authorEntityList.stream()
                .map(this::fromDbo)
                .collect(Collectors.toList());
    }

    public StudentDto fromDbo(StudentEntity authorEntity){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(authorEntity, StudentDto.class);
    }
    public StudentEntity toDbo(StudentDto authorDto){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(authorDto, StudentEntity.class);
    }
}
