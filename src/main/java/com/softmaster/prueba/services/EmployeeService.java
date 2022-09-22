package com.softmaster.prueba.services;

import com.softmaster.prueba.models.EmployeeModel;
import com.softmaster.prueba.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<EmployeeModel> readAll() throws Exception {
        return repository.findAll();
    }

    public EmployeeModel createEmployee(EmployeeModel employee) {
        return repository.save(employee);
    }
}
