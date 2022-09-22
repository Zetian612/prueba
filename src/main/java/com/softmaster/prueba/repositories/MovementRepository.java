package com.softmaster.prueba.repositories;

import com.softmaster.prueba.models.MovementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<MovementModel, Integer> {

    @Query(value = "SELECT * FROM movements WHERE id_enterprise = :id", nativeQuery = true)
    List<MovementModel> findByEnterpriseId(Integer id);

}
