package com.abha.prep.controller;

import com.abha.prep.dto.Student;
import com.abha.prep.entity.StudentEntity;
import com.abha.prep.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentRestController {

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<StudentEntity>> getAllStudent(){

        List<StudentEntity> allStudent = studentService.getAllStudent();
        System.out.println("Size : "+allStudent);

        return ResponseEntity.ok(allStudent);
    }
}
