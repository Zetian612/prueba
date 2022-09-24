package com.softmaster.prueba.services;

import com.softmaster.prueba.models.EmployeeModel;
import com.softmaster.prueba.models.EnterpriseModel;
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

    public void createEmployee(Integer id, EmployeeModel employee) {
        employee.setIdEnterprise(id);
        repository.save(employee);
    }

    public List<EmployeeModel> listEmployeeByEnterprise(Integer id) {
        return repository.findByIdEnterprise(id);
    }

    public void deleteEmployee(Integer id) {
        repository.deleteById(id);
    }

    public EmployeeModel getEmployee(Integer id) {
        return repository.findById(id).get();
    }

    public void updateEmployee(Integer id, EmployeeModel employee) {
        employee.setIdEmployee(id);
        repository.save(employee);
    }
}
