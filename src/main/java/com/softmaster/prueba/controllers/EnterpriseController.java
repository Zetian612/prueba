package com.softmaster.prueba.controllers;

import com.softmaster.prueba.models.EnterpriseModel;
import com.softmaster.prueba.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping(method = RequestMethod.GET , value = "/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService service;

    @GetMapping()
    public String listAllEnterprise(Model model) {
        model.addAttribute("enterprises", service.listAllEnterprise());
        return "enterprise/home";
    }

    @GetMapping("/new")
    public String newEnterprise(Model model) {
        model.addAttribute("enterprise", new EnterpriseModel());
        return "enterprise/create";
    }

    @PostMapping("/create")
    public RedirectView createEnterprise(@ModelAttribute EnterpriseModel enterprise, Model model) {
        model.addAttribute("enterprise");
        service.createEnterprise(enterprise);
        return new RedirectView("/enterprise");
    }

    @GetMapping("/{id}/edit")
    public String editEnterprise(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("enterprise", service.getEnterprise(id));
        return "enterprise/edit";
    }
    @PostMapping("/{id}/update")
    public RedirectView updateEnterprise(@PathVariable("id") Integer id, @ModelAttribute EnterpriseModel enterprise, Model model) {
        model.addAttribute("enterprise");
        service.updateEnterprise(id, enterprise);
        return new RedirectView("/enterprise");
    }

    //eliminar empresa
    @PostMapping("/{id}/delete")
    public RedirectView deleteEnterprise(@PathVariable Integer id) {
        service.deleteEnterprise(id);
        return new RedirectView("/enterprise");
    }
}
