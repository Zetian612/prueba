package com.softmaster.prueba.controllers;

import com.softmaster.prueba.models.EmployeeModel;
import com.softmaster.prueba.services.EmployeeService;
import com.softmaster.prueba.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/enterprise")
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping("/{id}/employees")
    public String enterpriseEmployees(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("employees", service.listEmployeeByEnterprise(id));
        return "employee/home";
    }

    @GetMapping("/{id}/employees/new")
    public String newEmployee(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("employee", new EmployeeModel());
        return "employee/create";
    }

    @PostMapping("/{id}/employees/create")
    public RedirectView createEmployee(@PathVariable("id") Integer id, @ModelAttribute EmployeeModel employee, Model model) {
        model.addAttribute("employee");
        service.createEmployee(id, employee);
        return new RedirectView("/enterprise/" + id + "/employees");
    }

    @GetMapping("/{idEnterprise}/employees/{id}/edit")
    public String editEmployee(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("employee", service.getEmployee(id));
        model.addAttribute("enterprises", enterpriseService.listAllEnterprise());
        return "employee/edit";
    }

    @PostMapping("/{idEnterprise}/employees/{id}/update")
    public RedirectView updateEmployee(@PathVariable("idEnterprise") Integer idEnterprise, @PathVariable("id") Integer id, @ModelAttribute EmployeeModel employee, Model model) {
        model.addAttribute("employee");
        service.updateEmployee(id, employee);
        return new RedirectView("/enterprise/" + idEnterprise + "/employees");
    }

    @PostMapping("/{idEnterprise}/employees/{id}/delete")
    public RedirectView deleteEmployee(@PathVariable("id") Integer id, @PathVariable("idEnterprise") Integer idEnterprise) {
        service.deleteEmployee(id);
        return new RedirectView("/enterprise/" + idEnterprise + "/employees");
    }

}
