package com.udea.comunicacionSoporte.mapper;

import com.udea.comunicacionSoporte.dto.CrearNotificacionInstitucionalDTO;
import com.udea.comunicacionSoporte.dto.NotificacionInstitucionalDTO;
import com.udea.comunicacionSoporte.entity.NotificacionInstitucional;
import com.udea.comunicacionSoporte.entity.TipoPublico;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NotificacionInstitucionalMapper {

    public NotificacionInstitucionalDTO toDTO(NotificacionInstitucional entity) {
        NotificacionInstitucionalDTO dto = new NotificacionInstitucionalDTO();
        dto.setIdNotificacionInstitucional(entity.getIdNotificacionInstitucional());
        dto.setIdEmpleadoAdmin(entity.getEmpleadoAdmin().getIdEmpleado());
        dto.setTituloNotificacion(entity.getTituloNotificacion());
        dto.setContenidoNotificacion(entity.getContenidoNotificacion());
        dto.setFechaPublicacion(entity.getFechaPublicacion());
        dto.setFechaExpiracion(entity.getFechaExpiracion());
        dto.setIdTipoPublico(entity.getTipoPublico().getIdTipoPublico());
        return dto;
    }

    public NotificacionInstitucional toEntity(CrearNotificacionInstitucionalDTO dto,
                                              com.udea.comunicacionSoporte.entity.Empleado empleadoAdmin,
                                              TipoPublico tipoPublico,
                                              LocalDateTime fechaPublicacion) {
        NotificacionInstitucional entity = new NotificacionInstitucional();
        entity.setEmpleadoAdmin(empleadoAdmin);
        entity.setTituloNotificacion(dto.getTituloNotificacion());
        entity.setContenidoNotificacion(dto.getContenidoNotificacion());
        entity.setFechaPublicacion(fechaPublicacion);
        entity.setFechaExpiracion(dto.getFechaExpiracion());
        entity.setTipoPublico(tipoPublico);
        return entity;
    }
}
