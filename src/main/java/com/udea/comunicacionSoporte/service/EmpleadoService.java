package com.udea.comunicacionSoporte.service;

import com.udea.comunicacionSoporte.dto.EmpleadoDTO;
import com.udea.comunicacionSoporte.dto.GestorDTO;
import com.udea.comunicacionSoporte.entity.CargoEmpleado;
import com.udea.comunicacionSoporte.entity.Empleado;
import com.udea.comunicacionSoporte.mapper.EmpleadoMapper;
import com.udea.comunicacionSoporte.repository.CargoEmpleadoRepository;
import com.udea.comunicacionSoporte.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private CargoEmpleadoRepository cargoRepository;

    public List<EmpleadoDTO> listarGestores() {
        return empleadoRepository.findAll()
                .stream()
                .map(EmpleadoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmpleadoDTO crearGestor(GestorDTO dto) {
        CargoEmpleado cargo = cargoRepository.findById(dto.getIdCargo())
                .orElseThrow(() -> new RuntimeException("Cargo no encontrado"));

        Empleado e = new Empleado();
        e.setNombreEmpleado(dto.getNombre());
        e.setApellidoEmpleado(dto.getApellido());
        e.setCorreoEmpleado(dto.getCorreo());
        e.setCargoEmpleado(cargo);
        Empleado guardado = empleadoRepository.save(e);
        return EmpleadoMapper.toDTO(guardado);
    }

    public EmpleadoDTO actualizarGestor(Long id, GestorDTO dto) {
        Empleado e = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        CargoEmpleado cargo = cargoRepository.findById(dto.getIdCargo())
                .orElseThrow(() -> new RuntimeException("Cargo no encontrado"));

        e.setNombreEmpleado(dto.getNombre());
        e.setApellidoEmpleado(dto.getApellido());
        e.setCorreoEmpleado(dto.getCorreo());
        e.setCargoEmpleado(cargo);
        Empleado actualizado = empleadoRepository.save(e);
        return EmpleadoMapper.toDTO(actualizado);
    }

    public void eliminarGestor(Long id) {
        if (!empleadoRepository.existsById(id)) {
            throw new RuntimeException("Gestor no encontrado con ID: " + id);
        }
        empleadoRepository.deleteById(id);
    }
}
