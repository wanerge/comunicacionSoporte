package com.udea.comunicacionSoporte.dto;

public class LoginResponseDTO {
    private String token;
    private String mensaje;
    private String rol;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String token, String mensaje, String rol) {
        this.token = token;
        this.mensaje = mensaje;
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
