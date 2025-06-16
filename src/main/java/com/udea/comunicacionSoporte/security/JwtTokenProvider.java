package com.udea.comunicacionSoporte.security;

import com.udea.comunicacionSoporte.entity.Usuario;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String SECRET_KEY = "Wz6lRtH1BQ9Sm3W8v5ZLjxwUkmKHzUsVQm6T2fRwI8s=";

    public String generarToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getCorreoUsuario())
                .claim("id", usuario.getIdUsuario())
                .claim("role", usuario.getTipoUsuario().getTipoUsuario())  // Ej: "Cliente", "Administrador"
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora
                .signWith(SignatureAlgorithm.HS256, Base64.getDecoder().decode(SECRET_KEY))
                .compact();
    }

    public Claims obtenerClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Base64.getDecoder().decode(SECRET_KEY))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean esValido(String token) {
        try {
            obtenerClaims(token); // Si no lanza excepción, es válido
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}



