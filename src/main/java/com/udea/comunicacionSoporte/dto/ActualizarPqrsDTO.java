package com.udea.comunicacionSoporte.dto;

public class ActualizarPqrsDTO {
    private Long idTipoPqrs;
    private String asuntoPqrs;
    private String descripcionPqrs;

    public ActualizarPqrsDTO() {
    }

    public ActualizarPqrsDTO(Long idTipoPqrs, String asuntoPqrs, String descripcionPqrs) {
        this.idTipoPqrs = idTipoPqrs;
        this.asuntoPqrs = asuntoPqrs;
        this.descripcionPqrs = descripcionPqrs;
    }

    public Long getIdTipoPqrs() {
        return idTipoPqrs;
    }

    public void setIdTipoPqrs(Long idTipoPqrs) {
        this.idTipoPqrs = idTipoPqrs;
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
