package com.udea.comunicacionSoporte.mapper;

import com.udea.comunicacionSoporte.dto.EmpleadoDTO;
import com.udea.comunicacionSoporte.entity.Empleado;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper {

    public static EmpleadoDTO toDTO(Empleado e) {
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setId(e.getIdEmpleado());
        dto.setNombre(e.getNombreEmpleado());
        dto.setApellido(e.getApellidoEmpleado());
        dto.setCorreo(e.getCorreoEmpleado());
        dto.setIdCargo(e.getCargoEmpleado().getIdCargoEmpleado());
        if (e.getUsuario() != null) {
            dto.setIdUsuario(e.getUsuario().getIdUsuario());
        }
        else {
            dto.setIdUsuario(null);
        }
        return dto;
    }

    public static Empleado toEntity(EmpleadoDTO dto) {
        Empleado e = new Empleado();
        e.setIdEmpleado(dto.getId());
        e.setNombreEmpleado(dto.getNombre());
        e.setApellidoEmpleado(dto.getApellido());
        e.setCorreoEmpleado(dto.getCorreo());
        return e;
    }
}
