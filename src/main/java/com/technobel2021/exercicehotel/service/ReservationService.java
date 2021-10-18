package com.technobel2021.exercicehotel.service;

import com.technobel2021.exercicehotel.dto.ReservationDTO;
import com.technobel2021.exercicehotel.entity.Reservation;
import com.technobel2021.exercicehotel.model.ReservationForm;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    void createReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void deleteReservation(Reservation reservation);
    List<Reservation> getAllReservation();
    Optional<Reservation> getOneById(Long id);
    ReservationDTO insert(ReservationForm form);
    Reservation DeleteById(Long id);

}
