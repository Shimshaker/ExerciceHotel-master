package com.technobel2021.exercicehotel.service;

import com.technobel2021.exercicehotel.entity.Utilisateur;
import com.technobel2021.exercicehotel.model.LoginForm;
import com.technobel2021.exercicehotel.repository.UtilisateurRepository;
import com.technobel2021.exercicehotel.security.JwtProvider;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private final UtilisateurRepository utilisateurRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;


    public SessionService(UtilisateurRepository utilisateurRepository, AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.utilisateurRepository = utilisateurRepository;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    public String login(LoginForm form){
        Utilisateur user = utilisateurRepository.findByUsername(form.getUsername())
                .orElseThrow( () -> new UsernameNotFoundException("L'utilisateur n'existe pas..."));

        //Créer L'authentication
        Authentication authentication = new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword());
        // Tester l'authentication
        authenticationManager.authenticate(authentication);

        // Si ok créer le token et le renvoyer

        return jwtProvider.createToken(user.getUsername(), user.getRoles());

    }



}
