package com.softmaster.prueba.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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

    // columnas de fecha de creacion y actualizacion
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
