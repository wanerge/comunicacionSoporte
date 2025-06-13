package com.udea.comunicacionSoporte.controller;

import com.udea.comunicacionSoporte.dto.ActualizarPqrsDTO;
import com.udea.comunicacionSoporte.dto.CrearPqrsDTO;
import com.udea.comunicacionSoporte.dto.PqrsDTO;
import com.udea.comunicacionSoporte.service.PqrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pqrs")
@CrossOrigin(origins = "*")
public class PqrsController {

    @Autowired
    private PqrsService pqrsService;

    @GetMapping
    public ResponseEntity<List<PqrsDTO>> listarTodas() {
        return ResponseEntity.ok(pqrsService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PqrsDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pqrsService.obtenerPorId(id));
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<PqrsDTO>> listarPorIdCliente(@PathVariable Long id) {
        return ResponseEntity.ok(pqrsService.listarPorIdCliente(id));
    }

    @GetMapping("/gestor/{id}")
    public ResponseEntity<List<PqrsDTO>> listarPorIdGestor(@PathVariable Long id) {
        return ResponseEntity.ok(pqrsService.listarPorIdGestor(id));
    }

    @GetMapping("/sinAsignar")
    public ResponseEntity<List<PqrsDTO>> obtenerPqrsSinGestores() {
        return ResponseEntity.ok(pqrsService.obtenerPqrsSinGestores());
    }

    @PostMapping
    public ResponseEntity<PqrsDTO> crear(@RequestBody CrearPqrsDTO dto) {
        return ResponseEntity.ok(pqrsService.crear(dto));
    }

    @PutMapping("/{idPqrs}")
    public ResponseEntity<PqrsDTO> actualizar(@PathVariable Long idPqrs, @RequestBody ActualizarPqrsDTO dto) {
        return ResponseEntity.ok(pqrsService.actualizar(idPqrs, dto));
    }

    @PutMapping("/{idPqrs}/gestor/{idGestor}")
    public ResponseEntity<PqrsDTO> actualizarGestor(@PathVariable Long idPqrs, @PathVariable Long idGestor) {
        return ResponseEntity.ok(pqrsService.actualizarGestor(idPqrs, idGestor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pqrsService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
