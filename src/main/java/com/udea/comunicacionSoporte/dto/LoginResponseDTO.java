package com.udea.comunicacionSoporte.dto;

public class LoginResponseDTO {
    private String token;
    private String mensaje;
    private String role;
    private Long id;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String token, String mensaje, String role, Long id) {
        this.token = token;
        this.mensaje = mensaje;
        this.role = role;
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
