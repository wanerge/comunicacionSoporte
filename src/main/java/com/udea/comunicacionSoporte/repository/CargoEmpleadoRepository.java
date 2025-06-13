package com.udea.comunicacionSoporte.repository;

import com.udea.comunicacionSoporte.entity.CargoEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoEmpleadoRepository extends JpaRepository<CargoEmpleado, Long> {
    CargoEmpleado findCargoEmpleadoByCargoEmpleado(String cargoEmpleado);
}
