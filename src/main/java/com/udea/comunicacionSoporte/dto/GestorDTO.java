package com.udea.comunicacionSoporte.dto;

public class GestorDTO {
    private String nombre;
    private String apellido;
    private String correo;
    private Long idCargo;

    public GestorDTO() {
    }

    public GestorDTO(String nombre, String apellido, String correo, Long idCargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.idCargo = idCargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Long idCargo) {
        this.idCargo = idCargo;
    }
}
