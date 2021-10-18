package com.technobel2021.exercicehotel.model;

import com.technobel2021.exercicehotel.entity.Utilisateur;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Validated
public class UtilisateurForm {

    @Length(min = 4, max = 20)
    @NotBlank
    private String username;
    @Length(min = 8)
    @NotBlank
    private String password;
    @NotEmpty
    private List<String> roles;

    public Utilisateur mapToUtilisateur(){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername(username);
        utilisateur.setPassword(password);
        utilisateur.setRoles(roles);

        return utilisateur;

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
