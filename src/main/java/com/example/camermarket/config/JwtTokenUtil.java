package com.example.camermarket.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenUtil {
    @Value("$(jwt.secret)")
    private final SecretKey secret;
    @Value("@(jwt.lifetime)")
    private final String jwtLifeTime;



    public String  generateAccessToken(UserDetails userDetails){
        Date date  = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuer("@luthfipun")
                .claim("roles",userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(date)
                .setExpiration( new Date(System.currentTimeMillis() + 60*60*1000))
                .signWith(secret,SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateAccessToken(String token) {

        try {
             Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token);
             return  true;
           }catch (ExpiredJwtException ex){
                 return  false;
        }
    }

    public Claims parseClaims(String token){
        return  Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getSubject(String  token){
        return  parseClaims(token).getSubject();
    }
}
