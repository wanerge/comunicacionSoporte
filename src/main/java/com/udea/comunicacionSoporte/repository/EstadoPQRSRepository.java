package com.udea.comunicacionSoporte.repository;

import com.udea.comunicacionSoporte.entity.EstadoPQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoPQRSRepository extends JpaRepository<EstadoPQRS, Long> {
    Optional<EstadoPQRS> findByEstadoPqrs(String estadoPqrs); 
}
