package com.softmaster.prueba.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "enterprises")
public class EnterpriseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_enterprise", nullable = false)
    private Integer idEnterprise;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @Column(length = 150, nullable = false, unique = true)
    private String nit;

    @Column(length = 150, nullable = false)
    private String address;

    @Column(length = 150, nullable = false)
    private String phone;

    // relacion con employee
    // borrado en cascada
     @OneToMany(mappedBy = "enterprise", cascade = CascadeType.REMOVE)
     private List<EmployeeModel> employees;

    // relacion con movement
    // borrado en cascada
     @OneToMany(mappedBy = "enterprise", cascade = CascadeType.REMOVE)
     private List<MovementModel> movements;

    // columnas de fecha de creacion y actualizacion
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;


}
