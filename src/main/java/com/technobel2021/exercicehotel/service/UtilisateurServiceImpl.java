package com.technobel2021.exercicehotel.service;

import com.technobel2021.exercicehotel.dto.UtilisateurDTO;
import com.technobel2021.exercicehotel.entity.Utilisateur;
import com.technobel2021.exercicehotel.exception.RoleInvalidException;
import com.technobel2021.exercicehotel.model.UtilisateurForm;
import com.technobel2021.exercicehotel.repository.UtilisateurRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return utilisateurRepository.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("L'utilisateur avec le username donné n'existe pas...!"));

    }

    @Override
    public Utilisateur insert(UtilisateurForm form) {
        if( form.getRoles().stream().anyMatch(role -> !role.equals("USER") && !role.equals("ADMIN")) )
            throw new RoleInvalidException();

        Utilisateur utilisateurToInsert = form.mapToUtilisateur();
        utilisateurToInsert.setPassword(passwordEncoder.encode(form.getPassword()));
        utilisateurToInsert.setUsername(form.getUsername());
        utilisateurToInsert.setRoles(form.getRoles());
        utilisateurToInsert.setAccountNonExpired(true);
        utilisateurToInsert.setAccountNonLocked(true);
        utilisateurToInsert.setCredentialsNonExpired(true);
        utilisateurToInsert.setEnabled(true);


        return utilisateurRepository.save(utilisateurToInsert);

    }

    @Override
    public UtilisateurDTO update(long id, UtilisateurForm form) {
        return null;
    }

    @Override
    public List<Utilisateur> getAll() {
        return new ArrayList<Utilisateur>(utilisateurRepository.findAll());

    }
}
