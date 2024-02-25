package com.learnspring.ems.service;

import com.learnspring.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    public EmployeeDto createEmployee(EmployeeDto employeeDto);

    public EmployeeDto getEmployeeById(Long id);

    public List<EmployeeDto> getEmployees();

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

    public EmployeeDto deleteEmployee(Long id);
}
