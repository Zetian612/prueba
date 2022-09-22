package com.softmaster.prueba.controllers;

import com.softmaster.prueba.models.EnterpriseModel;
import com.softmaster.prueba.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService service;

    @GetMapping()
    public List<EnterpriseModel> listAllEnterprise() {
        return service.listAllEnterprise();
    }

    @PostMapping()
    public EnterpriseModel createEnterprise(@RequestBody EnterpriseModel enterprise) {
        return service.createEnterprise(enterprise);
    }

    @GetMapping("/{id}")
    public EnterpriseModel getEnterprise(@PathVariable("id") Integer id) {
        return service.getEnterprise(id);
    }

    @PutMapping("/{id}")
    public EnterpriseModel updateEnterprise(@PathVariable("id") Integer id, @RequestBody EnterpriseModel enterprise) {
        return service.updateEnterprise(id, enterprise);
    }

    @DeleteMapping("/{id}")
    public void deleteEnterprise(@PathVariable("id") Integer id) {
        service.deleteEnterprise(id);
    }
}
