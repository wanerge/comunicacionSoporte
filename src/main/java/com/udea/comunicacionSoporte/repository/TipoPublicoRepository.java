package com.udea.comunicacionSoporte.repository;

import com.udea.comunicacionSoporte.entity.TipoPublico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPublicoRepository extends JpaRepository<TipoPublico, Long> {
}
