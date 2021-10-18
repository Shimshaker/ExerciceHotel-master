package com.technobel2021.exercicehotel.dto;

import com.technobel2021.exercicehotel.entity.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

public class ReservationDTO {


    private long id;
    private Date startDate;
    private Date endDate;
    private Inclusive inclusive;
    private Set<Chambre> chambres;
    private Collection<Consommation> consommation;

    @Data
    @Builder
    public static class Chambre{

        private long id;
        private int numero;
        private int nbrPlace;
        private TypeChambre type;
        private Collection<Reservation> reservation;

    }
}
