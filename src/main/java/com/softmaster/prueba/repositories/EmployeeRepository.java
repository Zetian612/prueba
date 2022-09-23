package com.softmaster.prueba.repositories;

import com.softmaster.prueba.models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {
    @Query(value = "SELECT * FROM employees WHERE id_enterprise = :id", nativeQuery = true)
    List<EmployeeModel> findByIdEnterprise(Integer id);

}
