package com.softmaster.prueba.services;

import com.softmaster.prueba.models.MovementModel;
import com.softmaster.prueba.repositories.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovementService {

    @Autowired
    private final MovementRepository repository;

    public MovementService(MovementRepository repository) {
        this.repository = repository;
    }

    public List<MovementModel> listTransactionByEnterprise(Integer id) {
        return repository.findByEnterpriseId(id);
    }

    public MovementModel createMovement(Integer id, MovementModel movement) {
        movement.setIdEnterprise(id);
        return repository.save(movement);
    }

    public MovementModel updateMovement(Integer id, Integer idMovement, MovementModel movement) {
        MovementModel movementModel = repository.findById(idMovement).get();
        movementModel.setConcept(movement.getConcept());
        movementModel.setAmount(movement.getAmount());
        movementModel.getEmployee().setIdEmployee(movement.getEmployee().getIdEmployee());
        movementModel.getEnterprise().setIdEnterprise(movement.getEnterprise().getIdEnterprise());
        return repository.save(movementModel);
    }

    public void deleteMovement(Integer id, Integer idMovement) {
        repository.deleteById(idMovement);
    }
}
