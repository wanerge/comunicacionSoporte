package com.udea.comunicacionSoporte.repository;

import com.udea.comunicacionSoporte.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByCargoEmpleado_CargoEmpleado(String cargoEmpleado);
}
