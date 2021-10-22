package com.schedulestudents.repository;

import com.schedulestudents.domain.dbo.StudentEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<StudentEntity, Integer> {



    void deleteById(int student);
}
