package com.udea.comunicacionSoporte.mapper;

import com.udea.comunicacionSoporte.dto.PqrsDTO;
import com.udea.comunicacionSoporte.entity.*;

public class PqrsMapper {

    public static PqrsDTO toDTO(PQRS pqrs) {
        PqrsDTO dto = new PqrsDTO();
        dto.setIdPqrs(pqrs.getIdPqrs());
        dto.setIdTipoPqrs(pqrs.getTipoPqrs().getIdTipoPqrs());
        if (pqrs.getEmpleadoGestor() != null) {
            dto.setIdEmpleadoGestor(pqrs.getEmpleadoGestor().getIdEmpleado());
        } else {
            dto.setIdEmpleadoGestor(null);
        }
        dto.setIdCliente(pqrs.getCliente().getIdCliente());
        dto.setAsuntoPqrs(pqrs.getAsuntoPqrs());
        dto.setDescripcionPqrs(pqrs.getDescripcionPqrs());
        dto.setIdEstadoPqrs(pqrs.getEstadoPqrs().getIdEstadoPqrs());
        dto.setFechaRadicacion(pqrs.getFechaRadicacion());
        dto.setFechaModificacion(pqrs.getFechaModificacion());
        dto.setFechaExpiracion(pqrs.getFechaExpiracion());
        return dto;
    }

    public static PQRS toEntity(PqrsDTO dto, TipoPQRS tipoPQRS, Cliente cliente, EstadoPQRS estado) {
        PQRS pqrs = new PQRS();
        pqrs.setTipoPqrs(tipoPQRS);
        pqrs.setCliente(cliente);
        pqrs.setAsuntoPqrs(dto.getAsuntoPqrs());
        pqrs.setDescripcionPqrs(dto.getDescripcionPqrs());
        pqrs.setEstadoPqrs(estado);
        pqrs.setFechaRadicacion(dto.getFechaRadicacion());
        pqrs.setFechaModificacion(dto.getFechaModificacion());
        pqrs.setFechaExpiracion(dto.getFechaExpiracion());
        return pqrs;
    }
}

