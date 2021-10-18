package com.technobel2021.exercicehotel;

import com.technobel2021.exercicehotel.entity.Client;
import com.technobel2021.exercicehotel.entity.MoyenPayement;
import com.technobel2021.exercicehotel.entity.Utilisateur;
import com.technobel2021.exercicehotel.repository.UtilisateurRepository;
import com.technobel2021.exercicehotel.service.ClientService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataBaseFiller implements InitializingBean {
    private final ClientService clientService;
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    public DataBaseFiller(ClientService clientService, UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
        this.clientService = clientService;
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;




    }



    @Override
    public void afterPropertiesSet() throws Exception {
        Client client = Client.builder()
                .nom("Harry")
                .prenom("Mary")
                .tel("+32474/474.206")
                .moyenPayement(MoyenPayement.BITCOIN)
                .build();

        clientService.createClient(client);

        Utilisateur user = new Utilisateur();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("pass"));

        user.setRoles(List.of("USER"));

        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);

        utilisateurRepository.save(user);

        Utilisateur admin = new Utilisateur();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("pass"));
        admin.setRoles(List.of("ADMIN", "USER"));

        admin.setAccountNonExpired(true);
        admin.setAccountNonLocked(true);
        admin.setEnabled(true);
        admin.setCredentialsNonExpired(true);

        utilisateurRepository.save(admin);


    }
}
