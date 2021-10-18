package com.technobel2021.exercicehotel.service;

import com.technobel2021.exercicehotel.dto.UtilisateurDTO;
import com.technobel2021.exercicehotel.entity.Utilisateur;
import com.technobel2021.exercicehotel.model.UtilisateurForm;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UtilisateurService extends UserDetailsService {

    Utilisateur insert(UtilisateurForm form);
    UtilisateurDTO update(long id, UtilisateurForm form);
    List<Utilisateur> getAll();

}
