package com.schedulestudents.repository;

import com.schedulestudents.domain.dbo.StudentEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<StudentEntity, Integer> {

    void deleteById(int student);
}
