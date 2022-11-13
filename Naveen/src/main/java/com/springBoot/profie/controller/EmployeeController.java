package com.springBoot.profie.controller;

import com.springBoot.profie.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    Employee employee;

    @GetMapping("/employee")
    public Map employeeDetias() {
        // Not the best practice to use a map to store differnt types!
        Map map = new HashMap();
        map.put("name", employee.name());
        map.put("role", employee.role());
        map.put("id", employee.id());
        map.put("detials",employee.detias());
        map.put("emai",employee.email());
        return map;
    }
}
