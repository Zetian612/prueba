package com.softmaster.prueba.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "employees")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_employee", nullable = false)
    private Integer idEmployee;

    @Column(length = 50, nullable = false)
    private String email;

    //relacion con enterprise
    @ManyToOne
    @JoinColumn(name = "id_enterprise", nullable = false)
    private EnterpriseModel enterprise;

    // relacion con movements
    // borrado en cascada
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<MovementModel> movements;

    // created_at
    @Column(name = "created_at")
    private Date createdAt;

    // updated_at
    @Column(name = "updated_at")
    private Date updatedAt;

    public void setIdEnterprise(Integer id) {
        this.enterprise = new EnterpriseModel();
        this.enterprise.setIdEnterprise(id);
    }
}
