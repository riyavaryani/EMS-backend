package com.learnspring.ems.controller;

import com.learnspring.ems.dto.EmployeeDto;
import com.learnspring.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        List<EmployeeDto> employeeDtos = employeeService.getEmployees();

        return ResponseEntity.ok(employeeDtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);

        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<EmployeeDto> deleteEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.deleteEmployee(employeeId);

        return ResponseEntity.ok(employeeDto);
    }
}
