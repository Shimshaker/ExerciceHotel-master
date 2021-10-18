package com.technobel2021.exercicehotel.model;

import com.technobel2021.exercicehotel.entity.Client;
import com.technobel2021.exercicehotel.entity.MoyenPayement;
import com.technobel2021.exercicehotel.entity.Reservation;
import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Validated
public class ClientForm {

    @NotBlank
    private String nom;
    @NotBlank
    private String prenom;
    @NotBlank
    private String tel;
    @NotNull
    private MoyenPayement moyenPayement;
    private Set<Reservation> reservations;


    public Client mapToClient(){
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setTel(tel);
        client.setMoyenPayement(moyenPayement);
        client.setReservations(reservations);

        return client;
    }
}
