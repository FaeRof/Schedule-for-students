package com.schedulestudents.repository;

import com.schedulestudents.domain.dbo.StudentEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;



public interface StudentRepository extends Repository<StudentEntity, Integer> {

    @Transactional(readOnly = true)
    Collection<StudentEntity> findAll() throws DataAccessException;
}
