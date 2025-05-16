package com.udea.comunicacionSoporte.repository;

import com.udea.comunicacionSoporte.entity.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PqrsRepository extends JpaRepository<PQRS, Long> {

    List<PQRS> findByClienteIdCliente(Long idCliente);

    List<PQRS> findByEmpleadoGestorIdEmpleado(Long idEmpleadoGestor);

}
