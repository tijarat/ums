package com.plover.ums.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;     // For Keys.hmacShaKeyFor()
import java.security.Key; 


@Component
public class JwtUtil {
    private final Key key;
    private final long jwtExpirationMs = 1000L * 60 * 60 * 24 * 365; // 24h (customize)

    public JwtUtil(@Value("${jwt.secret}") String secret) {
        // The secret should be Base64-encoded or a secure random key. Here we decode:
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

public String generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();

    // Add roles and rights as a claim
    claims.put("authorities", userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()));

    return Jwts.builder()
               .setClaims(claims)
               .setSubject(userDetails.getUsername())
               .setIssuedAt(new Date())
               .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
               .signWith(key, SignatureAlgorithm.HS256)  // <-- corrected
               .compact();
}



    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
}
