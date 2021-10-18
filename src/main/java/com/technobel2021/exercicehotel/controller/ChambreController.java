package com.technobel2021.exercicehotel.controller;

import com.technobel2021.exercicehotel.dto.ChambreDTO;
import com.technobel2021.exercicehotel.entity.Chambre;
import com.technobel2021.exercicehotel.model.ChambreForm;
import com.technobel2021.exercicehotel.service.ChambreService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/chambre")
public class ChambreController {
    private final ChambreService chambreService;

    public ChambreController(ChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @GetMapping(path = {"/all"})
    public List<Chambre> getAll() {return chambreService.getAllChambre();}

    @PostMapping(path = {"/add"})
    public ChambreDTO insert(@Valid @RequestBody ChambreForm form, @RequestHeader HttpHeaders headers){

        for (String key : headers.keySet()) {
            System.out.println(headers.get(key));

        }

        return chambreService.insert(form);

    }

    @DeleteMapping("/numero")
    public Chambre delete(Integer numero){

        return chambreService.deleteChambreByNumero(numero);

    }

}
