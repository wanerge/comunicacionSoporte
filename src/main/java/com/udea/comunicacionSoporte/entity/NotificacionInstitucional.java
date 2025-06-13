package com.udea.comunicacionSoporte.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tblnotificacionesinstitucionales")
public class NotificacionInstitucional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion_institucional")
    private Long idNotificacionInstitucional;

    @ManyToOne
    @JoinColumn(name = "id_empleado_admin", nullable = false)
    private Empleado empleadoAdmin;

    @Column(name = "titulo_notificacion", nullable = false, length = 255)
    private String tituloNotificacion;

    @Column(name = "contenido_notificacion", nullable = false, columnDefinition = "TEXT")
    private String contenidoNotificacion;

    @Column(name = "fecha_publicacion", nullable = false, updatable = false)
    private LocalDateTime fechaPublicacion;

    @Column(name = "fecha_expiracion")
    private LocalDateTime fechaExpiracion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_publico", nullable = false)
    private TipoPublico tipoPublico;
}
