package com.udea.comunicacionSoporte.repository;

import com.udea.comunicacionSoporte.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCorreoCliente(String correoCliente);

    Optional<Cliente> findByUsuario_IdUsuario(Long idUsuario);
}
