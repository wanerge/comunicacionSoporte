package com.udea.comunicacionSoporte.repository;

import com.udea.comunicacionSoporte.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCorreoCliente(String correoCliente);
}
