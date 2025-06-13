package com.udea.comunicacionSoporte.repository;

import com.udea.comunicacionSoporte.entity.NotificacionInstitucional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionInstitucionalRepository extends JpaRepository<NotificacionInstitucional, Long> {
}
