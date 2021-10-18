package com.technobel2021.exercicehotel.controller;


import com.technobel2021.exercicehotel.dto.ReservationDTO;
import com.technobel2021.exercicehotel.entity.Reservation;
import com.technobel2021.exercicehotel.model.ReservationForm;
import com.technobel2021.exercicehotel.service.ReservationService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(path = {"/all"})
    public List<Reservation> getAll(){return reservationService.getAllReservation();}

    @PostMapping(path = {"/add"})
    public ReservationDTO insert(@Valid @RequestBody ReservationForm form, @RequestHeader HttpHeaders headers){

        for (String key : headers.keySet()) {
            System.out.println(headers.get(key));

        }

        return reservationService.insert(form);
    }

    @DeleteMapping("/id")
    public Reservation delete(Long id){

        return reservationService.DeleteById(id);

    }



}
