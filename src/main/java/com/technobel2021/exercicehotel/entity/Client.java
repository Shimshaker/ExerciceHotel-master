package com.technobel2021.exercicehotel.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Table(name = "client")

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String tel;
    @Enumerated
    private MoyenPayement moyenPayement;
    @Column(nullable = true)
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Reservation> reservations;

}
