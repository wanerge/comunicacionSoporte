package com.udea.comunicacionSoporte.service;

import com.udea.comunicacionSoporte.dto.LoginRequestDTO;
import com.udea.comunicacionSoporte.dto.LoginResponseDTO;
import com.udea.comunicacionSoporte.dto.RegistroUsuarioDTO;
import com.udea.comunicacionSoporte.entity.SesionUsuario;
import com.udea.comunicacionSoporte.entity.TipoUsuario;
import com.udea.comunicacionSoporte.entity.Usuario;
import com.udea.comunicacionSoporte.repository.SesionUsuarioRepository;
import com.udea.comunicacionSoporte.repository.TipoUsuarioRepository;
import com.udea.comunicacionSoporte.repository.UsuarioRepository;
import com.udea.comunicacionSoporte.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepo;
    private final TipoUsuarioRepository tipoUsuarioRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final SesionUsuarioRepository sesionUsuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepo, TipoUsuarioRepository tipoUsuarioRepo, BCryptPasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, SesionUsuarioRepository sesionUsuarioRepository) {
        this.usuarioRepo = usuarioRepo;
        this.tipoUsuarioRepo = tipoUsuarioRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.sesionUsuarioRepository = sesionUsuarioRepository;
    }

    public Usuario registrarUsuario(RegistroUsuarioDTO dto) {
        if (usuarioRepo.existsByCorreoUsuario(dto.getCorreo())) {
            throw new RuntimeException("Ya existe un usuario con ese correo.");
        }

        TipoUsuario tipo = tipoUsuarioRepo.findByTipoUsuario(dto.getTipoUsuario())
                .orElseThrow(() -> new RuntimeException("Tipo de usuario no válido."));

        Usuario usuario = new Usuario();
        usuario.setCorreoUsuario(dto.getCorreo());
        usuario.setClaveHash(passwordEncoder.encode(dto.getClave()));
        usuario.setTipoUsuario(tipo);
        usuario.setFechaRegistro(LocalDateTime.now());

        return usuarioRepo.save(usuario);
    }

    public LoginResponseDTO login(LoginRequestDTO request) {
        Usuario usuario = usuarioRepo.findByCorreoUsuario(request.getCorreo())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(request.getClave(), usuario.getClaveHash())) {
            throw new RuntimeException("Clave incorrecta");
        }

        String token = jwtTokenProvider.generarToken(usuario);
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime expiracion = inicio.plusHours(1); // 1 hora

        SesionUsuario sesion = new SesionUsuario();
        sesion.setUsuario(usuario);
        sesion.setTokenSesion(token);
        sesion.setFechaInicio(inicio);
        sesion.setFechaExpiracion(expiracion);
        sesion.setActivo(true);

        sesionUsuarioRepository.save(sesion);

        return new LoginResponseDTO(token, "Inicio de sesión exitoso");
    }
}