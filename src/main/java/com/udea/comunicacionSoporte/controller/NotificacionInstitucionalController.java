package com.udea.comunicacionSoporte.controller;

import com.udea.comunicacionSoporte.dto.ActualizarNotificacionInstitucionalDTO;
import com.udea.comunicacionSoporte.dto.CrearNotificacionInstitucionalDTO;
import com.udea.comunicacionSoporte.dto.NotificacionInstitucionalDTO;
import com.udea.comunicacionSoporte.service.NotificacionInstitucionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@CrossOrigin(origins = "*")
public class NotificacionInstitucionalController {

    @Autowired
    private NotificacionInstitucionalService notificacionService;

    @GetMapping
    public ResponseEntity<List<NotificacionInstitucionalDTO>> listarTodas() {
        return ResponseEntity.ok(notificacionService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacionInstitucionalDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(notificacionService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<NotificacionInstitucionalDTO> crear(@RequestBody CrearNotificacionInstitucionalDTO dto) {
        return ResponseEntity.ok(notificacionService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacionInstitucionalDTO> actualizar(@PathVariable Long id, @RequestBody ActualizarNotificacionInstitucionalDTO dto) {
        return ResponseEntity.ok(notificacionService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        notificacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
