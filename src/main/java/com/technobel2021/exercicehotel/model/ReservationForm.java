package com.technobel2021.exercicehotel.model;


import com.technobel2021.exercicehotel.entity.Chambre;
import com.technobel2021.exercicehotel.entity.Consommation;
import com.technobel2021.exercicehotel.entity.Inclusive;
import com.technobel2021.exercicehotel.entity.Reservation;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Data
@Validated
public class ReservationForm {

    private long id;
    private Date startDate;
    private Date endDate;
    @NotNull
    private Inclusive inclusive;
    private Set<Chambre> chambres;
    private Collection<Consommation> consommation;

    public Reservation mapToReservation(){
        Reservation reservation = new Reservation();
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);
        reservation.setInclusive(inclusive);
        reservation.setChambres(chambres);
        reservation.setConsommation(consommation);

        return reservation;

    }
}
