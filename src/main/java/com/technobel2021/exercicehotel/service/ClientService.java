package com.technobel2021.exercicehotel.service;

import com.technobel2021.exercicehotel.dto.ClientDTO;
import com.technobel2021.exercicehotel.entity.Client;
import com.technobel2021.exercicehotel.model.ClientCreateForm;
import com.technobel2021.exercicehotel.model.ClientForm;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    ClientCreateForm createClient(Client client);
    void updateClient(Client client);
    Client deleteClientById(Long id);
    List<Client> getAllClient();
    ClientDTO insert(ClientForm form);
    Optional<Client> getOneById(Long id);

}
