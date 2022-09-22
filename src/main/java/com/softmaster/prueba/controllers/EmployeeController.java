package com.softmaster.prueba.controllers;

import com.softmaster.prueba.models.EmployeeModel;
import com.softmaster.prueba.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<EmployeeModel> readAll() throws Exception {
        return service.readAll();
    }

    @PostMapping
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employee) {
        return service.createEmployee(employee);
    }

}
