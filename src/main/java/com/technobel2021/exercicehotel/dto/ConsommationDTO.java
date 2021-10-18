package com.technobel2021.exercicehotel.dto;

import com.technobel2021.exercicehotel.entity.Reservation;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Data
public class ConsommationDTO {

    private long id;
    private String nom;
    private String marque;
    private double prix;
    private Set<Reservation> reservation;


}
