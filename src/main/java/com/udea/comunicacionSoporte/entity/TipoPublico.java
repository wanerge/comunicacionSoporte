package com.udea.comunicacionSoporte.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbltipospublicos")
public class TipoPublico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_publico")
    private Long idTipoPublico;

    @Column(name = "tipo_publico", nullable = false, unique = true, length = 50)
    private String tipoPublico;
}
