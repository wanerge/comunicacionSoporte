package com.udea.comunicacionSoporte.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbltiposusuarios")
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario")
    private Long idTipoUsuario;

    @Column(name = "tipo_usuario", unique = true, nullable = false)
    private String tipoUsuario;

    public TipoUsuario() {
    }

    public TipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
