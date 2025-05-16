package com.udea.comunicacionSoporte.controller;

import com.udea.comunicacionSoporte.dto.LoginRequestDTO;
import com.udea.comunicacionSoporte.dto.LoginResponseDTO;
import com.udea.comunicacionSoporte.dto.RegistroUsuarioDTO;
import com.udea.comunicacionSoporte.entity.Usuario;
import com.udea.comunicacionSoporte.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrar(@RequestBody RegistroUsuarioDTO dto) {
        Usuario creado = usuarioService.registrarUsuario(dto);
        return ResponseEntity.ok(creado);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        LoginResponseDTO response = usuarioService.login(loginRequest);
        return ResponseEntity.ok(response);
    }

}
