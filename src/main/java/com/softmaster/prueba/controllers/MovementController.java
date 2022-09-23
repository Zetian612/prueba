package com.softmaster.prueba.controllers;

import com.softmaster.prueba.models.MovementModel;
import com.softmaster.prueba.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/enterprise")
public class MovementController {

    @Autowired
    private MovementService service;

    @GetMapping("/{id}/movements")
    public String enterpriseMovements(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("movements", service.listTransactionByEnterprise(id));
        return "movement/home";
    }

    @GetMapping("/{id}/movements/new")
    public String newMovement(@PathVariable("id") Integer id) {
        return "movement/create";
    }

    @PostMapping("/{id}/movements/create")
    public MovementModel createMovement(@PathVariable("id") Integer id, @RequestBody MovementModel movement) {
        return service.createMovement(id, movement);
    }

    @PutMapping("/{id}/movements/{idMovement}")
    public MovementModel updateMovement(@PathVariable("id") Integer id, @PathVariable("idMovement") Integer idMovement, @RequestBody MovementModel movement) {
        return service.updateMovement(id, idMovement, movement);
    }

    @DeleteMapping("/{id}/movements/{idMovement}")
    public void deleteMovement(@PathVariable("id") Integer id, @PathVariable("idMovement") Integer idMovement) {
        service.deleteMovement(id, idMovement);
    }

}
