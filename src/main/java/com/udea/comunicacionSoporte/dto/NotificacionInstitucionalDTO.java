package com.udea.comunicacionSoporte.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class NotificacionInstitucionalDTO {
    private Long idNotificacionInstitucional;
    private Long idEmpleadoAdmin;
    private String tituloNotificacion;
    private String contenidoNotificacion;
    private LocalDateTime fechaPublicacion;
    private LocalDateTime fechaExpiracion;
    private Long idTipoPublico;
}
