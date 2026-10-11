package com.abha.prep.service.impl;

import com.abha.prep.dto.EmployeeDomainModel;
import com.abha.prep.dto.EmployeeDto;
import com.abha.prep.entity.EmployeeEntity;
import com.abha.prep.repository.EmployeeRepository;
import com.abha.prep.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> getAllEmployee(){

        List<EmployeeEntity> allEmployee = employeeRepository.findAll();

        List<EmployeeDto> allEmployeeDto = allEmployee.stream().map(ls->{

            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(ls.getId());
            employeeDto.setName(ls.getName());
            return employeeDto;
                }

        ).toList();

        return allEmployeeDto;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDomainModel employeeDomainModel) {

        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(employeeDomainModel.getName());
        EmployeeEntity emp = employeeRepository.save(entity);

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(emp.getId());
        employeeDto.setName(emp.getName());
        return employeeDto;
    }

    @Override
    public EmployeeDto findEmployee(long employeeId) {

        EmployeeDto employeeDto = null;
        Optional<EmployeeEntity> entity = employeeRepository.findById(employeeId);

        if(entity.isPresent()){
            EmployeeEntity employee = entity.get();
            employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getId());
            employeeDto.setName(employee.getName());
        }
        return employeeDto;
    }

    @Override
    public String deleteEmployee(long employeeId) {

        String recordReturn = null;
        employeeRepository.deleteById(employeeId);

        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) {
            System.out.println("Record deleted successfully!");
            recordReturn = "Record deleted successfully!";
        } else {
            System.out.println("Record still exists!");
            recordReturn = "Record not deleted!";
        }

        return recordReturn;
    }
}
