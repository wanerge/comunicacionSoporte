package com.udea.comunicacionSoporte.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DetallePqrsDTO {
    private Long idPqrs;
    private String TipoPqrs;
    private String asuntoPqrs;
    private String descripcionPqrs;
    private String EstadoPqrs;
    private LocalDateTime fechaRadicacion;
}
