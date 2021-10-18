package com.technobel2021.exercicehotel.dto;

import com.technobel2021.exercicehotel.entity.Reservation;
import com.technobel2021.exercicehotel.entity.TypeChambre;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

public class ChambreDTO {

    private long id;
    private int numero;
    private int nbrPlace;
    private TypeChambre type;
    private Collection<Reservation> reservation;

    @Data
    @Builder
    private static class ConsommationDTO{

        private long id;
        private String nom;
        private String marque;
        private double prix;
        private Set<Reservation> reservation;

    }

}
