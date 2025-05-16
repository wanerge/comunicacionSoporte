package com.udea.comunicacionSoporte.dto;

public class RegistroUsuarioDTO {
    private String correo;
    private String clave;
    private String tipoUsuario; // Ej: "cliente", "gestor", etc.

    public RegistroUsuarioDTO() {
    }

    public RegistroUsuarioDTO(String correo, String clave, String tipoUsuario) {
        this.correo = correo;
        this.clave = clave;
        this.tipoUsuario = tipoUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
