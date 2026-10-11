package com.abha.prep.service.interfaces;

import com.abha.prep.dto.EmployeeDomainModel;
import com.abha.prep.dto.EmployeeDto;

import java.util.List;

public interface IEmployeeService {

    public List<EmployeeDto> getAllEmployee();
    public EmployeeDto saveEmployee(EmployeeDomainModel employeeDomainModel);
    public EmployeeDto findEmployee(long employeeId);
    public String deleteEmployee(long employeeId);
}
