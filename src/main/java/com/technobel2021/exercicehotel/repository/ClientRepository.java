package com.technobel2021.exercicehotel.repository;


import com.technobel2021.exercicehotel.entity.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {

    Boolean existsByTel(String tel);

}
