package com.abha.prep.repository;

import com.abha.prep.entity.EmployeeEntity;
import com.abha.prep.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
