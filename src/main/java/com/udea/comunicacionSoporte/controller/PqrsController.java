package com.udea.comunicacionSoporte.controller;

import com.udea.comunicacionSoporte.dto.*;
import com.udea.comunicacionSoporte.service.PqrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasAnyRole('Administrador','Cliente')")
@RestController
@RequestMapping("/api/pqrs")
@CrossOrigin(origins = "*")
public class PqrsController {

    @Autowired
    private PqrsService pqrsService;

    @PreAuthorize("hasRole('Administrador')")
    @GetMapping
    public ResponseEntity<List<PqrsDTO>> listarTodas() {
        return ResponseEntity.ok(pqrsService.listarTodas());
    }

    @PreAuthorize("hasAnyRole('Administrador','Cliente')")
    @GetMapping("/{id}")
    public ResponseEntity<DetallePqrsDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pqrsService.obtenerPorId(id));
    }

    @PreAuthorize("hasAnyRole('Administrador','Cliente')")
    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<ResumenPqrsDTO>> listarPorIdCliente(@PathVariable Long id) {
        return ResponseEntity.ok(pqrsService.listarPorIdCliente(id));
    }

    @PreAuthorize("hasRole('Administrador')")
    @GetMapping("/gestor/{id}")
    public ResponseEntity<List<PqrsDTO>> listarPorIdGestor(@PathVariable Long id) {
        return ResponseEntity.ok(pqrsService.listarPorIdGestor(id));
    }

    @PreAuthorize("hasRole('Administrador')")
    @GetMapping("/sinAsignar")
    public ResponseEntity<List<PqrsDTO>> obtenerPqrsSinGestores() {
        return ResponseEntity.ok(pqrsService.obtenerPqrsSinGestores());
    }

    @PreAuthorize("hasAnyRole('Administrador','Cliente')")
    @PostMapping
    public ResponseEntity<PqrsDTO> crear(@RequestBody CrearPqrsDTO dto) {
        return ResponseEntity.ok(pqrsService.crear(dto));
    }

    @PreAuthorize("hasAnyRole('Administrador','Cliente')")
    @PutMapping("/{idPqrs}")
    public ResponseEntity<DetallePqrsDTO> actualizar(@PathVariable Long idPqrs, @RequestBody ActualizarPqrsDTO dto) {
        return ResponseEntity.ok(pqrsService.actualizar(idPqrs, dto));
    }

    @PreAuthorize("hasRole('Administrador')")
    @PutMapping("/{idPqrs}/gestor/{idGestor}")
    public ResponseEntity<PqrsDTO> actualizarGestor(@PathVariable Long idPqrs, @PathVariable Long idGestor) {
        return ResponseEntity.ok(pqrsService.actualizarGestor(idPqrs, idGestor));
    }

    @PreAuthorize("hasAnyRole('Administrador','Cliente')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pqrsService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
