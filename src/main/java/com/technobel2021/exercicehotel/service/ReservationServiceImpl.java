package com.technobel2021.exercicehotel.service;

import com.technobel2021.exercicehotel.dto.ReservationDTO;
import com.technobel2021.exercicehotel.entity.Reservation;
import com.technobel2021.exercicehotel.exception.ElementNotFoundException;
import com.technobel2021.exercicehotel.model.ReservationForm;
import com.technobel2021.exercicehotel.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void createReservation(Reservation reservation) {

        reservationRepository.save(reservation);

    }

    @Override
    public void updateReservation(Reservation reservation) {

        reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public List<Reservation> getAllReservation() {

        return new ArrayList<Reservation>((Collection<? extends Reservation>) reservationRepository.findAll());
    }

    @Override
    public Optional<Reservation> getOneById(Long id) {

        if (reservationRepository.existsById(id))
            throw new ElementNotFoundException();

        return reservationRepository.findById(id);

    }

    @Override
    public ReservationDTO insert(ReservationForm form) {

        Reservation reservation = form.mapToReservation();
        reservationRepository.save(reservation);

        return null;
    }

    @Override
    public Reservation DeleteById(Long id) {
        reservationRepository.deleteById(id);
        return null;
    }
}
