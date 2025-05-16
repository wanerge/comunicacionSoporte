package com.udea.comunicacionSoporte.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tblcargosempleados")
public class CargoEmpleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCargoEmpleado;

    @Column(nullable = false, unique = true)
    private String cargoEmpleado;

    public CargoEmpleado() {
    }

    public CargoEmpleado(String cargoEmpleado) {
        this.cargoEmpleado = cargoEmpleado;
    }

    // Getters and Setters
    public Long getIdCargoEmpleado() {
        return idCargoEmpleado;
    }

    public void setIdCargoEmpleado(Long idCargoEmpleado) {
        this.idCargoEmpleado = idCargoEmpleado;
    }

    public String getCargoEmpleado() {
        return cargoEmpleado;
    }

    public void setCargoEmpleado(String cargoEmpleado) {
        this.cargoEmpleado = cargoEmpleado;
    }
}
