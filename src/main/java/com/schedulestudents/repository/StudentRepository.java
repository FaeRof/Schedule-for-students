package com.schedulestudents.repository;

import com.schedulestudents.domain.dbo.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    void deleteById(int student);
}
