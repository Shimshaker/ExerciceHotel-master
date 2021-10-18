package com.technobel2021.exercicehotel.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "chambre")
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chambre {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Id
    @Column(nullable = false, unique = true)
    private int numero;
    @Column(nullable = false)
    private int nbrPlace;
    @Enumerated
    private TypeChambre type;
    @OneToMany(mappedBy = "chambres")
    private Collection<Reservation> reservation;

}
