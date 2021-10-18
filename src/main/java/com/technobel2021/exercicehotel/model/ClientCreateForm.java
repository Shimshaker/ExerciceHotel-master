package com.technobel2021.exercicehotel.model;

import com.technobel2021.exercicehotel.entity.Client;
import com.technobel2021.exercicehotel.entity.MoyenPayement;
import com.technobel2021.exercicehotel.entity.Reservation;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@Validated
@Data
@Builder
public class ClientCreateForm {

    private String nom;
    private String prenom;
    private String tel;
    private MoyenPayement moyenPayement;



    public Client mapToClient(){
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setTel(tel);
        client.setMoyenPayement(moyenPayement);


        return client;
    }

}
