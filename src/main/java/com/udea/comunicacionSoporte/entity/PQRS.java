package com.udea.comunicacionSoporte.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tblpqrs")
public class PQRS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pqrs")
    private Long idPqrs;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pqrs", nullable = false)
    private TipoPQRS tipoPqrs;

    @ManyToOne
    @JoinColumn(name = "id_empleado_gestor")
    private Empleado empleadoGestor;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "asunto_pqrs", nullable = false)
    private String asuntoPqrs;

    @Column(name = "descripcion_pqrs", nullable = false, columnDefinition = "TEXT")
    private String descripcionPqrs;

    @ManyToOne
    @JoinColumn(name = "id_estado_pqrs", nullable = false)
    private EstadoPQRS estadoPqrs;

    @Column(name = "fecha_radicacion", nullable = false, updatable = false)
    private LocalDateTime fechaRadicacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "fecha_expiracion")
    private LocalDateTime fechaExpiracion;

    public PQRS() {
    }

    public PQRS(TipoPQRS tipoPqrs, Empleado empleadoGestor, Cliente cliente, String asuntoPqrs, String descripcionPqrs, EstadoPQRS estadoPqrs, LocalDateTime fechaRadicacion) {
        this.tipoPqrs = tipoPqrs;
        this.empleadoGestor = empleadoGestor;
        this.cliente = cliente;
        this.asuntoPqrs = asuntoPqrs;
        this.descripcionPqrs = descripcionPqrs;
        this.estadoPqrs = estadoPqrs;
        this.fechaRadicacion = fechaRadicacion;
    }

    // Getters and Setters
    public Long getIdPqrs() {
        return idPqrs;
    }

    public void setIdPqrs(Long idPqrs) {
        this.idPqrs = idPqrs;
    }

    public TipoPQRS getTipoPqrs() {
        return tipoPqrs;
    }

    public void setTipoPqrs(TipoPQRS tipoPqrs) {
        this.tipoPqrs = tipoPqrs;
    }

    public Empleado getEmpleadoGestor() {
        return empleadoGestor;
    }

    public void setEmpleadoGestor(Empleado empleadoGestor) {
        this.empleadoGestor = empleadoGestor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public EstadoPQRS getEstadoPqrs() {
        return estadoPqrs;
    }

    public void setEstadoPqrs(EstadoPQRS estadoPqrs) {
        this.estadoPqrs = estadoPqrs;
    }

    public LocalDateTime getFechaRadicacion() {
        return fechaRadicacion;
    }

    public void setFechaRadicacion(LocalDateTime fechaRadicacion) {
        this.fechaRadicacion = fechaRadicacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
