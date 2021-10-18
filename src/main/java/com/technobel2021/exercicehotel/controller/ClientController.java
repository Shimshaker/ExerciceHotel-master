package com.technobel2021.exercicehotel.controller;

import com.technobel2021.exercicehotel.dto.ClientDTO;
import com.technobel2021.exercicehotel.entity.Client;
import com.technobel2021.exercicehotel.model.ClientCreateForm;
import com.technobel2021.exercicehotel.model.ClientForm;
import com.technobel2021.exercicehotel.service.ClientService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@Controller
@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = { "/all"})
    public List<Client> getAll(){
        return clientService.getAllClient();
    }

//    @PostMapping(
//            path = "/add",
//            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
//    public ClientCreateForm handleBrowserSubmissions(Client client) throws Exception {
//
//        // Save feedback data
//
//        return clientService.createClient(client);
//    }

    @PostMapping(path = {"/add"})
    public ClientDTO insert(@Valid @RequestBody ClientForm form, @RequestHeader HttpHeaders headers) {

        for (String key : headers.keySet()) {
            System.out.println( headers.get(key) );
        }

        return clientService.insert(form);


    }
    @DeleteMapping(params = "id")
    public Client deleteByParam(@RequestParam(name = "id") Long id){

        return clientService.deleteClientById(id);
    }

    @DeleteMapping("/id")
    public Client delete(Long id){

        return clientService.deleteClientById(id);

    }





}






