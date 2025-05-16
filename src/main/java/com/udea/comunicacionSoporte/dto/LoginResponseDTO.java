package com.udea.comunicacionSoporte.dto;

public class LoginResponseDTO {
    private String token;
    private String mensaje;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String token, String mensaje) {
        this.token = token;
        this.mensaje = mensaje;
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
}
