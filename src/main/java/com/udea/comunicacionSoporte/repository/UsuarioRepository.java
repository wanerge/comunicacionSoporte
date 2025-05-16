package com.udea.comunicacionSoporte.repository;

import com.udea.comunicacionSoporte.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByCorreoUsuario(String correoUsuario);
    Optional<Usuario> findByCorreoUsuario(String correoUsuario);
}

