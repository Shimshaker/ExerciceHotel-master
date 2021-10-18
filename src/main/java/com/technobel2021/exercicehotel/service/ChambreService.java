package com.technobel2021.exercicehotel.service;

import com.technobel2021.exercicehotel.dto.ChambreDTO;
import com.technobel2021.exercicehotel.entity.Chambre;
import com.technobel2021.exercicehotel.model.ChambreForm;

import java.util.List;
import java.util.Optional;

public interface ChambreService {

    ChambreDTO insert(ChambreForm form);
    void updateChambre(Chambre chambre);
    void deleteChambre(Chambre chambre);
    List<Chambre> getAllChambre();
    Optional<Chambre> getOneById(Long id);
    Chambre deleteChambreByNumero(Integer numero);

}
