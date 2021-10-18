package com.technobel2021.exercicehotel.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "consommation")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Consommation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String marque;
    @Column(nullable = false)
    private double prix;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Reservation> reservation;

}