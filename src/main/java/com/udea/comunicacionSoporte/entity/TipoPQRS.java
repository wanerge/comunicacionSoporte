package com.udea.comunicacionSoporte.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbltipospqrs")
public class TipoPQRS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoPqrs;

    @Column(nullable = false, unique = true)
    private String tipoPqrs;

    public TipoPQRS() {
    }
    public TipoPQRS(String tipoPqrs) {
        this.tipoPqrs = tipoPqrs;
    }
    // Getters and Setters
    public Long getIdTipoPqrs() {
        return idTipoPqrs;
    }

    public void setIdTipoPqrs(Long idTipoPqrs) {
        this.idTipoPqrs = idTipoPqrs;
    }

    public String getTipoPqrs() {
        return tipoPqrs;
    }

    public void setTipoPqrs(String tipoPqrs) {
        this.tipoPqrs = tipoPqrs;
    }
}
