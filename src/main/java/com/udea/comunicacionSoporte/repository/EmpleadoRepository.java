package com.udea.comunicacionSoporte.repository;

import com.udea.comunicacionSoporte.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
