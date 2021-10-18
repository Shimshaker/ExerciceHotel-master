package com.technobel2021.exercicehotel.model;

import com.technobel2021.exercicehotel.entity.Chambre;
import com.technobel2021.exercicehotel.entity.Reservation;
import com.technobel2021.exercicehotel.entity.TypeChambre;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@Validated
public class ChambreForm {

    private long id;
    private int numero;
    private int nbrPlace;
    @NotNull
    private TypeChambre type;
    private Collection<Reservation> reservation;

    public Chambre mapToChambre(){
        Chambre chambre = new Chambre();
        chambre.setNumero(numero);
        chambre.setNbrPlace(nbrPlace);
        chambre.setType(type);
        chambre.setReservation(reservation);

        return chambre;

    }

}
