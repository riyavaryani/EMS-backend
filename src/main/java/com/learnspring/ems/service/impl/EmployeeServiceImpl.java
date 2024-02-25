package com.learnspring.ems.service.impl;

import com.learnspring.ems.dto.EmployeeDto;
import com.learnspring.ems.entity.Employee;
import com.learnspring.ems.exception.ResourceNotFoundException;
import com.learnspring.ems.mapper.EmployeeMapper;
import com.learnspring.ems.repository.EmployeeRepository;
import com.learnspring.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist for this employee Id: " + id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public EmployeeDto deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist for this employee Id: " + id));
        employeeRepository.deleteById(id);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
