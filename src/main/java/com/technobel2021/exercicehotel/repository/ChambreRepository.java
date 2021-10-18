package com.technobel2021.exercicehotel.repository;


import com.technobel2021.exercicehotel.entity.Chambre;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "chambre", path = "chambre")
public interface ChambreRepository extends PagingAndSortingRepository<Chambre, Long> {

        boolean existsByNumero(Integer numero);
        void deleteChambreByNumero(Integer numero);

}
