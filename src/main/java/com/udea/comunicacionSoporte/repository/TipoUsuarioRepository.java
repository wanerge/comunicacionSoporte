package com.udea.comunicacionSoporte.repository;

import com.udea.comunicacionSoporte.entity.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {
    Optional<TipoUsuario> findByTipoUsuario(String tipoUsuario);
}
