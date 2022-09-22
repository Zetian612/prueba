package com.softmaster.prueba.services;

import com.softmaster.prueba.models.EnterpriseModel;
import com.softmaster.prueba.repositories.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService {


    private final EnterpriseRepository repository;

    public EnterpriseService(EnterpriseRepository repository) {
        this.repository = repository;
    }

    public List<EnterpriseModel> listAllEnterprise() {
        return repository.findAll();
    }


    public EnterpriseModel createEnterprise(EnterpriseModel enterprise) {
        return repository.save(enterprise);
    }

    public EnterpriseModel getEnterprise(Integer id) {
        return repository.findById(id).get();
    }

    public EnterpriseModel updateEnterprise(Integer id, EnterpriseModel enterprise) {
        EnterpriseModel enterpriseModel = repository.findById(id).get();
        enterpriseModel.setName(enterprise.getName());
        enterpriseModel.setNit(enterprise.getNit());
        enterpriseModel.setAddress(enterprise.getAddress());
        enterpriseModel.setPhone(enterprise.getPhone());
        return repository.save(enterpriseModel);
    }

    public void deleteEnterprise(Integer id) {
        repository.deleteById(id);
    }


    public Optional<EnterpriseModel> getEnterpriseWithMovements(Integer id) {
        return repository.findById(id);
    }
}
