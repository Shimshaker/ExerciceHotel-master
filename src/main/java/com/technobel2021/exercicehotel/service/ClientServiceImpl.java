package com.technobel2021.exercicehotel.service;

import com.technobel2021.exercicehotel.dto.ClientDTO;
import com.technobel2021.exercicehotel.entity.Client;
import com.technobel2021.exercicehotel.exception.ElementAlreadyExistsException;
import com.technobel2021.exercicehotel.exception.ElementNotFoundException;
import com.technobel2021.exercicehotel.model.ClientCreateForm;
import com.technobel2021.exercicehotel.model.ClientForm;
import com.technobel2021.exercicehotel.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientCreateForm createClient(Client client) {

        clientRepository.save(client);

        return null;
    }

    @Override
    public void updateClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client deleteClientById(Long id) {

        if (!clientRepository.existsById(id))
           throw  new ElementNotFoundException();

        clientRepository.deleteById(id);

        return null;
    }

    @Override
    public List<Client> getAllClient() {
        return new ArrayList<Client>((Collection<? extends Client>) clientRepository.findAll());

    }

    @Override
    public ClientDTO insert(ClientForm form) {

        if (clientRepository.existsByTel(form.getTel()))
            throw new ElementAlreadyExistsException();

        Client client = form.mapToClient();
        clientRepository.save(client);

        return null;

    }

    @Override
    public Optional<Client> getOneById(Long id) {
        return clientRepository.findById(id);
    }
}
