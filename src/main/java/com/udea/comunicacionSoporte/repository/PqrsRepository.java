package com.udea.comunicacionSoporte.repository;

import com.udea.comunicacionSoporte.entity.Empleado;
import com.udea.comunicacionSoporte.entity.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PqrsRepository extends JpaRepository<PQRS, Long> {

    List<PQRS> findByClienteIdCliente(Long idCliente);
    List<PQRS> findByEmpleadoGestorIdEmpleado(Long idEmpleadoGestor);
    List<PQRS> findByEmpleadoGestorIsNull();
}
