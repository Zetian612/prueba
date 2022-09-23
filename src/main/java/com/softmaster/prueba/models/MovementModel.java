package com.softmaster.prueba.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "movements")
public class MovementModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_movement", nullable = false)
    private Integer idMovement;

    @Column(length = 50, nullable = false)
    private String concept;

    @Column(length = 50, nullable = false)
    private Float amount;

    //relacion con employee
    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false)
    private EmployeeModel employee;

    //relacion con enterprise y borrado en cascada
    @ManyToOne
    @JoinColumn(name = "id_enterprise", nullable = false)
    private EnterpriseModel enterprise;

    // created_at
    @Column(name = "created_at" )
    private Date createdAt;

    // updated_at
    @Column(name = "updated_at")
    private Date updatedAt;

    public void setIdEnterprise(Integer id) {
        this.enterprise.setIdEnterprise(id);
    }
}
