package com.abha.prep.service.impl;

import com.abha.prep.entity.StudentEntity;
import com.abha.prep.repository.StudentRepository;
import com.abha.prep.service.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<StudentEntity> getAllStudent(){

        List<StudentEntity> allStudent = studentRepository.findAll();

        return allStudent;
    }
}
