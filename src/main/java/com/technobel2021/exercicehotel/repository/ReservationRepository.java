package com.technobel2021.exercicehotel.repository;

import com.technobel2021.exercicehotel.entity.Reservation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "reservation", path = "reservation")
public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Long> {

    void deleteById(Long id);

}
