package com.udea.comunicacionSoporte.repository;

import com.udea.comunicacionSoporte.entity.TipoPQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPQRSRepository extends JpaRepository<TipoPQRS, Long> {
}
