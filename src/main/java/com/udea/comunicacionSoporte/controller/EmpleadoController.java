package com.udea.comunicacionSoporte.controller;

import com.udea.comunicacionSoporte.dto.EmpleadoDTO;
import com.udea.comunicacionSoporte.dto.GestorDTO;
import com.udea.comunicacionSoporte.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('Administrador')")
@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/gestores")
    public ResponseEntity<List<EmpleadoDTO>> listarGestores() {
        return ResponseEntity.ok(empleadoService.listarGestores());
    }

    @PostMapping("/gestores")
    public ResponseEntity<EmpleadoDTO> crearGestor(@RequestBody GestorDTO dto) {
        return ResponseEntity.ok(empleadoService.crearGestor(dto));
    }

    @PutMapping("/gestores/{id}")
    public ResponseEntity<EmpleadoDTO> actualizarGestor(@PathVariable Long id, @RequestBody GestorDTO dto) {
        return ResponseEntity.ok(empleadoService.actualizarGestor(id, dto));
    }

    @DeleteMapping("/gestores/{id}")
    public ResponseEntity<Void> eliminarGestor(@PathVariable Long id) {
        empleadoService.eliminarGestor(id);
        return ResponseEntity.noContent().build();
    }
}
