package com.abha.prep.controller;

import com.abha.prep.dto.EmployeeDomainModel;
import com.abha.prep.dto.EmployeeDto;
import com.abha.prep.dto.FetchEmployee;
import com.abha.prep.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FetchEmployee> getAllStudent(){

        List<EmployeeDto> allEmployee = employeeService.getAllEmployee();
        System.out.println("Size : "+allEmployee);

        FetchEmployee employeeList = new FetchEmployee();
        employeeList.setEmployees(allEmployee);
        return ResponseEntity.ok(employeeList);
    }

    @PostMapping(value = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDomainModel employeeDomainModel){

        EmployeeDto employeeDto = employeeService.saveEmployee(employeeDomainModel);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping(value = "/find/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("employeeId") Long id){
        System.out.println("Inside PathVariable");
        EmployeeDto employeeDto = employeeService.findEmployee(id);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping(value = "/findEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> findEmployee(@RequestParam("employeeId") Long id){

        System.out.println("Inside RequestParam");
        EmployeeDto employeeDto = employeeService.findEmployee(id);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping(value = "/deleteEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteEmployee(@RequestParam("employeeId") Long id){

        String employeeDto = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(employeeDto);
    }
}
