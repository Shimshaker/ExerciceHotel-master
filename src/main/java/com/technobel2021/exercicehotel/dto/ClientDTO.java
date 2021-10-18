package com.technobel2021.exercicehotel.dto;

import com.technobel2021.exercicehotel.entity.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
public class ClientDTO {

    private long id;
    private String nom;
    private String prenom;
    private String tel;
    private MoyenPayement moyenPayement;
    private Set<Reservation> reservations;

    @Data
    @Builder
    public static class ReservationDTO{

        private long id;
        private java.sql.Date startDate;
        private java.sql.Date endDate;
        private Inclusive inclusive;
        private Set<Chambre> chambres;
        private Collection<Consommation> consommation;

    }

}
