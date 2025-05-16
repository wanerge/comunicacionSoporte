package com.udea.comunicacionSoporte.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tblestadopqrs")
public class EstadoPQRS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstadoPqrs;

    @Column(nullable = false, unique = true)
    private String estadoPqrs;

    public EstadoPQRS() {
    }

    public EstadoPQRS(String estadoPqrs) {
        this.estadoPqrs = estadoPqrs;
    }

    // Getters and Setters
    public Long getIdEstadoPqrs() {
        return idEstadoPqrs;
    }

    public void setIdEstadoPqrs(Long idEstadoPqrs) {
        this.idEstadoPqrs = idEstadoPqrs;
    }

    public String getEstadoPqrs() {
        return estadoPqrs;
    }

    public void setEstadoPqrs(String estadoPqrs) {
        this.estadoPqrs = estadoPqrs;
    }
}
