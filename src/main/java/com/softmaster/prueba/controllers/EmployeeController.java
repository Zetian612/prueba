package com.softmaster.prueba.controllers;

import com.softmaster.prueba.models.EmployeeModel;
import com.softmaster.prueba.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/enterprise")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/{id}/employees")
    public String enterpriseEmployees(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("employees", service.listEmployeeByEnterprise(id));
        return "employee/home";
    }

    @GetMapping("/{id}/employees/new")
    public String newEmployee(Model model) {
        model.addAttribute("employees", new EmployeeModel());
        return "employee/create";
    }

    @PostMapping
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employee) {
        return service.createEmployee(employee);
    }

}
