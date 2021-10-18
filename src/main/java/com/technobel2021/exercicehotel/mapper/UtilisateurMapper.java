package com.technobel2021.exercicehotel.mapper;

import com.technobel2021.exercicehotel.dto.UtilisateurDTO;
import com.technobel2021.exercicehotel.entity.Utilisateur;
import com.technobel2021.exercicehotel.model.UtilisateurForm;

public class UtilisateurMapper {

    public UtilisateurDTO toDTO(Utilisateur utilisateur){
        if( utilisateur == null )
            return null;

        return UtilisateurDTO.builder()
                .id(utilisateur.getId())
                .username(utilisateur.getUsername())
                .roles(utilisateur.getRoles())
                .accountNonExpired(utilisateur.isAccountNonExpired())
                .accountNonLocked(utilisateur.isAccountNonLocked())
                .credentialsNonExpired(utilisateur.isCredentialsNonExpired())
                .enabled(utilisateur.isEnabled())
                .build();
    }

    public Utilisateur formToEntity(UtilisateurForm form){
        if( form == null )
            return null;

        Utilisateur u = new Utilisateur();
        u.setUsername(form.getUsername());
        u.setPassword(form.getPassword());
        u.setRoles(form.getRoles());

        return u;
    }
}
