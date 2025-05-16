package com.udea.comunicacionSoporte.dto;

import java.time.LocalDateTime;

public class PqrsDTO {

    private Long idPqrs;
    private Long idTipoPqrs;
    private Long idEmpleadoGestor;
    private Long idCliente;
    private String asuntoPqrs;
    private String descripcionPqrs;
    private Long idEstadoPqrs;
    private LocalDateTime fechaRadicacion;
    private LocalDateTime fechaModificacion;
    private LocalDateTime fechaExpiracion;

    public PqrsDTO() {
    }

    public PqrsDTO(Long idPqrs, Long idTipoPqrs, Long idEmpleadoGestor, Long idCliente, String asuntoPqrs, String descripcionPqrs, Long idEstadoPqrs, LocalDateTime fechaRadicacion, LocalDateTime fechaModificacion, LocalDateTime fechaExpiracion) {
        this.idPqrs = idPqrs;
        this.idTipoPqrs = idTipoPqrs;
        this.idEmpleadoGestor = idEmpleadoGestor;
        this.idCliente = idCliente;
        this.asuntoPqrs = asuntoPqrs;
        this.descripcionPqrs = descripcionPqrs;
        this.idEstadoPqrs = idEstadoPqrs;
        this.fechaRadicacion = fechaRadicacion;
    }

    // Getters y setters
    public Long getIdPqrs() {
        return idPqrs;
    }

    public void setIdPqrs(Long idPqrs) {
        this.idPqrs = idPqrs;
    }

    public Long getIdTipoPqrs() {
        return idTipoPqrs;
    }

    public void setIdTipoPqrs(Long idTipoPqrs) {
        this.idTipoPqrs = idTipoPqrs;
    }

    public Long getIdEmpleadoGestor() {
        return idEmpleadoGestor;
    }

    public void setIdEmpleadoGestor(Long idEmpleadoGestor) {
        this.idEmpleadoGestor = idEmpleadoGestor;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getAsuntoPqrs() {
        return asuntoPqrs;
    }

    public void setAsuntoPqrs(String asuntoPqrs) {
        this.asuntoPqrs = asuntoPqrs;
    }

    public String getDescripcionPqrs() {
        return descripcionPqrs;
    }

    public void setDescripcionPqrs(String descripcionPqrs) {
        this.descripcionPqrs = descripcionPqrs;
    }

    public Long getIdEstadoPqrs() {
        return idEstadoPqrs;
    }

    public void setIdEstadoPqrs(Long idEstadoPqrs) {
        this.idEstadoPqrs = idEstadoPqrs;
    }

    public LocalDateTime getFechaRadicacion() {
        return fechaRadicacion;
    }

    public void setFechaRadicacion(LocalDateTime fechaRadicacion) {
        this.fechaRadicacion = fechaRadicacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}


