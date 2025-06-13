package com.udea.comunicacionSoporte.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CrearNotificacionInstitucionalDTO {
    private Long idEmpleadoAdmin;
    private String tituloNotificacion;
    private String contenidoNotificacion;
    private LocalDateTime fechaExpiracion;
    private Long idTipoPublico;
}
