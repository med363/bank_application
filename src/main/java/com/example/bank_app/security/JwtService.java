package com.example.bank_app.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.function.Function;

@Service
public class JwtService {
    /*cle secret key ==> see file application.yml*/
    @Value("${security.jwt.secret-key}")
    private String secretkey ;
    public String extractUsername(String token) {
        /*claims == information */
        return extractClaim(token, Claims::getSubject);
    }

    /*generique methode*/
    private <T> T extractClaim(String token, Function<Claims,T> claimsResolve) {
        final Claims claims = extractAllClaims(token);
        return claimsResolve.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningkey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    private Key getSigningkey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretkey);
        return keys.hmacShakeyFor(keyBytes);
    }
}
