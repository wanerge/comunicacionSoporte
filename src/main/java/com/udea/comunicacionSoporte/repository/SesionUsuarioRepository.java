package com.udea.comunicacionSoporte.repository;

import com.udea.comunicacionSoporte.entity.SesionUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SesionUsuarioRepository extends JpaRepository<SesionUsuario, Long> {

    Optional<SesionUsuario> findByTokenSesion(String tokenSesion);
}
