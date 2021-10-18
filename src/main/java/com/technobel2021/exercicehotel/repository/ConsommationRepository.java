package com.technobel2021.exercicehotel.repository;

import com.technobel2021.exercicehotel.entity.Consommation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "consommation", path = "consommation")
public interface ConsommationRepository extends PagingAndSortingRepository<Consommation, Long> {


}
