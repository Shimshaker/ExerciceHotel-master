package com.technobel2021.exercicehotel.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Table(name = "reservation")
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE", insertable = false, nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date startDate;
    @Column(name = "END_DATE", columnDefinition = "DATE")
    private Date endDate;
    @Enumerated
    private Inclusive inclusive;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Chambre> chambres;
    @OneToMany(mappedBy = "reservation")
    private Collection<Consommation> consommation;

}

