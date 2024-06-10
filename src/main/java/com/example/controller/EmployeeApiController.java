package com.example.controller;

import com.example.domain.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeApiController {
  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/findByName")
  public List<Employee> findByName(@RequestParam(required = false) String name) {
    if (name == null || name.isEmpty()) return null;
    return employeeService.findByName(name);
  }
}
