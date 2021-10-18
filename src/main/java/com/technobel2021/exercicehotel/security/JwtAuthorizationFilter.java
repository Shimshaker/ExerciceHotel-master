package com.technobel2021.exercicehotel.security;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;

    public JwtAuthorizationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Récupérer le token
        String token = jwtProvider.resolveToken(request);
        // Vérifier si le token est valide
        if (token != null && jwtProvider.validate(token)){
            //Si valid => enregistrer l'utilisateur contenu authentifé avec ses roles
            Authentication auth = jwtProvider.getAuth(token);
            SecurityContextHolder.getContext().setAuthentication(auth);

        }

        filterChain.doFilter(request, response);

    }

}

