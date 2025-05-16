package com.udea.comunicacionSoporte.security;

import com.udea.comunicacionSoporte.entity.Usuario;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // Usamos una clave secreta codificada en Base64
    private final String SECRET_KEY = "Wz6lRtH1BQ9Sm3W8v5ZLjxwUkmKHzUsVQm6T2fRwI8s=";  // Base64

    public String generarToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getCorreoUsuario())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora
                .signWith(SignatureAlgorithm.HS256, Base64.getDecoder().decode(SECRET_KEY)) // Decodificamos la clave
                .compact();
    }

    public String obtenerCorreoDesdeToken(String token) {
        JwtParser parser = Jwts.parserBuilder().setSigningKey(Base64.getDecoder().decode(SECRET_KEY)).build();
        return parser.parseClaimsJws(token).getBody().getSubject();
    }

    public boolean esValido(String token) {
        try {
            JwtParser parser = Jwts.parserBuilder().setSigningKey(Base64.getDecoder().decode(SECRET_KEY)).build();
            parser.parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}


