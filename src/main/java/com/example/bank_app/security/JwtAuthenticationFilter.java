package com.example.bank_app.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/*filter ala kol requette*/
@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
/*inject jwtservice*/
    private final JwtService jwtService;
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {
        //log
        log.info("filter executed");
        // je doit verif Bearer token ili mawjoud fil en tete mta3 requette
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        //valide token
        final String jwt;
        /*cree userEmail== QR code of ticket pour generee un token*/
        final String userEmail;
        if (authHeader = null || !authHeader.startsWith("Bearer ")) {
            //log
            log.info("No bearer token is present");
            filterChain.doFilter(request, response);
            return;
        }
        /*extract jwt header a partir position 7*/
        jwt = authHeader.substring(7);
        /*valide(expiree ou non ,generee token...) avec jwt service*/
         /*extract userEmail jwt service*/
        userEmail = jwtService.extractUsername(jwt);

    }
}
