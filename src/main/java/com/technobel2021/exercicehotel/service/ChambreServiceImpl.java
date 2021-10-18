package com.technobel2021.exercicehotel.service;

import com.technobel2021.exercicehotel.dto.ChambreDTO;
import com.technobel2021.exercicehotel.entity.Chambre;
import com.technobel2021.exercicehotel.exception.ElementAlreadyExistsException;
import com.technobel2021.exercicehotel.exception.ElementNotFoundException;
import com.technobel2021.exercicehotel.model.ChambreForm;
import com.technobel2021.exercicehotel.repository.ChambreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ChambreServiceImpl implements ChambreService {
    private final ChambreRepository chambreRepository;

    public ChambreServiceImpl(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    @Override
    public ChambreDTO insert(ChambreForm form) {

        if (chambreRepository.existsByNumero(form.getNumero()))
            throw new ElementAlreadyExistsException();

        Chambre chambre = form.mapToChambre();

        chambreRepository.save(chambre);

        return null;
    }

    @Override
    public void updateChambre(Chambre chambre) {
        if (!chambreRepository.existsByNumero(chambre.getNumero()))
            throw new ElementNotFoundException();

        chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Chambre chambre) {
        if (chambreRepository.existsByNumero(chambre.getNumero()))
            throw new ElementNotFoundException();

        chambreRepository.delete(chambre);

    }

    @Override
    public List<Chambre> getAllChambre() {
        return new ArrayList<Chambre>((Collection<? extends Chambre>) chambreRepository.findAll());
    }

    @Override
    public Optional<Chambre> getOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public Chambre deleteChambreByNumero(Integer numero) {
        if (chambreRepository.existsByNumero(numero))
            throw new ElementNotFoundException();

        chambreRepository.deleteChambreByNumero(numero);

        return null;
    }
}
