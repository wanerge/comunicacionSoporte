package com.udea.comunicacionSoporte.dto;

public class RegistroUsuarioDTO {
    private String correo;
    private String clave;
    private Long idTipoUsuario;

    public RegistroUsuarioDTO() {
    }

    public RegistroUsuarioDTO(String correo, String clave, Long idTipoUsuario) {
        this.correo = correo;
        this.clave = clave;
        this.idTipoUsuario = idTipoUsuario;
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

    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
}
