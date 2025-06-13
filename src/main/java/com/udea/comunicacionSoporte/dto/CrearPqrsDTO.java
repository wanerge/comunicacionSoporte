package com.udea.comunicacionSoporte.dto;

public class CrearPqrsDTO {
    private Long idTipoPqrs;
    private Long idCliente;
    private String asuntoPqrs;
    private String descripcionPqrs;

    public CrearPqrsDTO() {
    }

    public CrearPqrsDTO(Long idTipoPqrs, Long idCliente, String asuntoPqrs, String descripcionPqrs) {
        this.idTipoPqrs = idTipoPqrs;
        this.idCliente = idCliente;
        this.asuntoPqrs = asuntoPqrs;
        this.descripcionPqrs = descripcionPqrs;
    }

    public Long getIdTipoPqrs() {
        return idTipoPqrs;
    }

    public void setIdTipoPqrs(Long idTipoPqrs) {
        this.idTipoPqrs = idTipoPqrs;
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
}
